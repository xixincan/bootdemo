package cn.exp.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @version 1.0.0
 * @Author: xixincan
 * 2019-07-04
 */
@Service
public class TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Async
    public Future<Integer> test(int i) throws InterruptedException {
        Thread.sleep(1L);
        System.out.println(i);
        return new AsyncResult<>(i * 10);
    }

    @Async
    public Future<Integer> test2(int i) {
        System.out.println(i * -1);
        return new AsyncResult<>(i * -10);
    }


    public String call() {
        LOGGER.info("任务开始执行，持续等待中...");

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.info("任务处理完成");
        return "操作成功";
    }

    @Async
    public String callAsync() {
        LOGGER.info("任务开始执行，持续等待中...");

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.info("任务处理完成");
        return "操作成功";
    }
}
