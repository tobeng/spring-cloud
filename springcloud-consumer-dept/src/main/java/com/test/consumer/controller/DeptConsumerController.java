package com.test.consumer.controller;

import com.test.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yr
 * @date 2018/09/16
 */
@RestController
public class DeptConsumerController {

    //private static String REST_URL_PREFIX = "http://localhost:8081";

    // SPRINGCLOUD-PROVIDER-DEPT 微服务名称
    private static String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    /**
     * 使用RestTemplate访问restful
     * (url, requestMap, ResponseBean.class)这三个参数分别表示REST请求地址、请求参数、HTTP请求转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/dept/list")
    public Boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/list", dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @GetMapping("/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") String deptNo){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptNo, Dept.class );
    }

    /**
     * 测试@EnableDiscoveryClient,消费端可以调用服务发现
     */
    @GetMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
