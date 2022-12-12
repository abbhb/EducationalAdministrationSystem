package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 查询所有的员工
     * @return
     */
    List<Employee> getAllEmployee();
}
