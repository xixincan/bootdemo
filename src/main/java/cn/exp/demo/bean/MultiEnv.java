package cn.exp.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: xixincan
 * @Date: 2019/5/8
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "env")
public class MultiEnv {

    private String env;

    private String os;

    public String getEnv() {
        return env;
    }

    public MultiEnv setEnv(String env) {
        this.env = env;
        return this;
    }

    public String getOs() {
        return os;
    }

    public MultiEnv setOs(String os) {
        this.os = os;
        return this;
    }

    @Override
    public String toString() {
        return "MultiEnv{" +
                "env='" + env + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
