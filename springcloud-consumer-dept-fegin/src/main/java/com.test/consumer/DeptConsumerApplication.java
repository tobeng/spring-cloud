package com.test.consumer;

import com.test.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yr
 * @date 2018/09/16
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.test.api","com.test.consumer"})
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = MyRule.class)
@EnableFeignClients(basePackages = {"com.test"})
public class DeptConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplication.class, args);
    }
}
