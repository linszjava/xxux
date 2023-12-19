package com.lin.xxux.service.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/11 10:33
 */
@SpringBootApplication
@MapperScan("com.lin.xxux.*.*.mapper")
@ComponentScan(basePackages = {"com.lin.xxux"})
@EnableDiscoveryClient
public class ServiceProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class,args);
        System.out.println("========xxux-service-product启动成功======");
    }
}
