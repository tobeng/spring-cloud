package com.test.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * 部门实体类
 * @date 2018/09/15
 * @author yr
 */
@Data
public class Dept {

    /**
     * 自增编号
     */
    private Integer id;
    /**
     * 部门编号
     */
    private String deptNo;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 资源数据库
     */
    private String dbSource;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
}
