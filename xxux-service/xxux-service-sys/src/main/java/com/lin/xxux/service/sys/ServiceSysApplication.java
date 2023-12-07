package com.lin.xxux.service.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/7 08:39
 */
@SpringBootApplication
@MapperScan("com.lin.xxux.*.*.mapper")
@ComponentScan(basePackages = {"com.lin.xxux"})
public class ServiceSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSysApplication.class, args);
        System.out.println("xxux-service-sys启动成功");
    }
}
