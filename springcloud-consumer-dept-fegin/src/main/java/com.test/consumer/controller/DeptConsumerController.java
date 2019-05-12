package com.test.consumer.controller;

import com.test.api.entity.Dept;
import com.test.api.service.DeptClientService;
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

    @Autowired
    private DeptClientService deptClientService;

    /**
     * 使用RestTemplate访问restful
     * (url, requestMap, ResponseBean.class)这三个参数分别表示REST请求地址、请求参数、HTTP请求转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/dept/list")
    public Boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @GetMapping("/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") String deptNo){
        return deptClientService.get(deptNo);
    }

}
