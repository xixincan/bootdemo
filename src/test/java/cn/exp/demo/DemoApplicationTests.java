package cn.exp.demo;

import cn.exp.demo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot的单元测试
 * 可以再测试期间很方便的类似编码一样进行自动注入的容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ioc;

	@Test
	public void contextLoads() {
        System.out.println(person);
	}

	@Test
	public void test() {
        System.out.println(this.ioc.containsBean("helloService"));
    }
}
