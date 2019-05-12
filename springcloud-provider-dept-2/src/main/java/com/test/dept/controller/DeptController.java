package com.test.dept.controller;

import com.test.api.entity.Dept;
import com.test.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yr
 * @date 2018/09/16
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public void add(@RequestBody Dept dept){
        deptService.add(dept);
    }

    @GetMapping("/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") String deptNo ){
        return deptService.get(deptNo);
    }

    @GetMapping("/list")
    public List<Dept> get(){
        return deptService.list();
    }

    @RequestMapping(value = "/com/test/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
