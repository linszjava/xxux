package com.lin.xxux.service.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/20 02:44
 */
@SpringBootApplication
@MapperScan("com.lin.xxux.*.*.mapper")
@ComponentScan(basePackages = {"com.lin.xxux"})
public class ServiceActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceActivityApplication.class,args);
        System.out.println("========xxux-service-activity-启动成功==================");
    }
}
