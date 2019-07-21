package cn.exp.demo.controller;

import cn.exp.demo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @Author: xixincan
 * @Date: 2019/4/25
 * @Version 1.0
 */
@Controller
public class HelloWordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWordController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }


    @RequestMapping("invoke")
    @ResponseBody
    public String invoke() {
        LOGGER.info("接收请求，开始处理...");
        String result = taskService.call();
        LOGGER.info("接收任务线程完成并退出");
        return result;
    }

    @RequestMapping("invoke2")
    @ResponseBody
    public String invoke2() {
        LOGGER.info("接收请求，开始处理...");
        String result = taskService.callAsync();
        LOGGER.info("接收任务线程完成并退出");
        return result;
    }

    @RequestMapping("call")
    @ResponseBody
    public Callable<String> callable() {

        LOGGER.info("接收请求，开始处理...");
        Callable<String> result =  new Callable<String>() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public String call() throws Exception {
                return taskService.call();
            }
        };
        LOGGER.info("接收任务线程完成并退出");
        return result;
    }

    @RequestMapping("deferred")
    @ResponseBody
    public DeferredResult<String> deferred() {
        LOGGER.info("接收请求，开始处理...");

        DeferredResult<String> result = new DeferredResult<>(3000L, "超时");
        result.onTimeout(() -> {
            LOGGER.warn("超时啦。。");
        });

        result.onCompletion(() -> {
            LOGGER.info("完成啦。。");
        });
        result.setResult(this.taskService.call());
        LOGGER.info("接收任务线程完成并退出");
        return result;
    }

}
