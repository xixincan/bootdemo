package cn.exp.demo;

import cn.exp.demo.service.TaskService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @version 1.0.0
 * @Author: xixincan
 * 2019-07-04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTask {

    @Autowired
    TaskService taskService;

    @Test
    public void test() throws Exception {
        for (int i=0; i<10; i++) {
            Future<Integer> test = taskService.test(i);
            Future<Integer> test2 = taskService.test2(i);
            han(test);
            han(test2);
            System.out.println("i=" + i);
        }
        Thread.sleep(7L);
    }

    List<Future<?>> list = new ArrayList<>();

    void han(Future<?> future) {
        list.add(future);
    }

    @After
    public void ssss() throws Exception {
        System.out.println(System.currentTimeMillis());
        for (Future future : list) {
            System.out.println(future.get());
        }
        System.out.println(System.currentTimeMillis());
    }
}
