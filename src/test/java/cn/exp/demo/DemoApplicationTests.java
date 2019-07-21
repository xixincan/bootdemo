package cn.exp.demo;

import cn.exp.demo.bean.MultiEnv;
import cn.exp.demo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ioc;

    @Autowired
    private MultiEnv multiEnv;

	@Test
	public void contextLoads() {
        System.out.println(person);
	}

	@Test
	public void test() {
        System.out.println(this.ioc.containsBean("helloService"));
    }

    @Test
    public void testMultiEnv() {
        System.out.println(multiEnv);
    }

    @Test
    public void testBootSl4j() {
	    LOGGER.trace("this is trace log...");
	    LOGGER.debug("of course this is debug log...");
	    //spring boot 默认级别是info级别
	    LOGGER.info("well, this is info level log...");
        LOGGER.warn("oops, here comes the warning logs,...");
        LOGGER.error("careful , error log is coming...");
    }
}
