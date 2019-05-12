package com.test.dept.service;

import com.test.api.entity.Dept;
import java.util.List;

/**
 * @author yr
 * @date 2018/09/16
 */
public interface DeptService {
    Boolean add(Dept dept);
    Dept get(String deptNo);
    List<Dept> list();
}
