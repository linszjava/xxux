package com.lin.xxux.service.acl;

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
 * @date 2023/11/21 00:08
 */
@SpringBootApplication
@MapperScan("com.lin.xxux.*.*.mapper")
@ComponentScan(basePackages = {"com.lin.xxux"})
@EnableDiscoveryClient
public class ServiceAclApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class,args);
        System.out.println("========xxux-service-acl启动成功======");
    }
}
