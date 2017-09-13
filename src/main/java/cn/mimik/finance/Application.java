package cn.mimik.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by liugang on 2017/9/13.
 *
 * Spring boot 应用启动类
 *
 *
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.mimik.finance"})
public class Application {

    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
