package com.test.dept.dao;

import com.test.api.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author yr
 * @date 2018/09/16
 */
@Mapper
public interface DeptDao {
    List<Dept> getAll();
    Boolean addDept(Dept dept);
    Dept getByDeptNo(String deptNo);
}
