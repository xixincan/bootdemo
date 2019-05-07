package cn.exp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xixincan
 * @Date: 2019/4/25
 * @Version 1.0
 */
@Controller
public class HelloWordController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

}
