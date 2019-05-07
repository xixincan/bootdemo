package cn.exp.demo.config;

import cn.exp.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前的类是一个配置类，就是代替之前的spring的xml配置文件
 *
 * @Author: xixincan
 * @Date: 2019/4/25
 * @Version 1.0
 */
@Configuration
public class BeanConfig {

    /**
     * 将方法的返回值添加到容器中，这个组件的ID默认就是方法名
     * @return
     */
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
