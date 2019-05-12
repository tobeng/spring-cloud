package com.test.dept;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yr
 * @date 201/09/16
 */
@ComponentScan(basePackages = {"com.test"})
@MapperScan(basePackages = {"com.test.dept.dao"})
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptApplication{

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class,args);
    }

}
