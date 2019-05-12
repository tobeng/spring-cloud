package com.test.dept.service.impl;

import com.test.api.entity.Dept;
import com.test.dept.dao.DeptDao;
import com.test.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author yr
 * @date 2018/09/16
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public Boolean add(Dept dept) {
        if (StringUtils.isEmpty(dept)){
            return false;
        }
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(String deptNo) {
        if(StringUtils.isEmpty(deptNo)){
            return null;
        }
        return deptDao.getByDeptNo(deptNo);
    }

    @Override
    public List<Dept> list() {
        return deptDao.getAll();
    }
}
