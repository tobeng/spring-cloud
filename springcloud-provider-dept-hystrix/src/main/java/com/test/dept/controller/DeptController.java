package com.test.dept.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @GetMapping("/get/{deptNo}")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("deptNo") String deptNo ){
        return deptService.get(deptNo);
    }


    public Dept processHystrix_Get(@PathVariable("deptNo") String id)
    {
        return new Dept();
    }


    @PostMapping("/add")
    public void add(@RequestBody Dept dept){
        deptService.add(dept);
    }

    @GetMapping("/list")
    public List<Dept> get(){
        return deptService.list();
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
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
