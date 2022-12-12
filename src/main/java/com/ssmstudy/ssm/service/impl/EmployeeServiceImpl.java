package com.ssmstudy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmstudy.ssm.mapper.EmployeeMapper;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.pojo.Employee;
import com.ssmstudy.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //为类中所有的方法开启事务管理
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public DataResult getAllEmployee() {
        List<Employee> employeeList = employeeMapper.getAllEmployee();
        DataResult dataResult = new DataResult();
        if (employeeList.size()!=0){
            dataResult.setMsg("获取成功");
            dataResult.setStatus(200);
            dataResult.setData(employeeList);
        }
        return dataResult;
    }

    @Override
    public DataResult getEmployeePage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> employeeList = employeeMapper.getAllEmployee();
        PageInfo<Employee> page = new PageInfo<>(employeeList,5);
        DataResult dataResult = new DataResult();
        if (employeeList.size()!=0){
            dataResult.setMsg("获取成功");
            dataResult.setStatus(200);
            dataResult.setData(page);
        }
        return dataResult;
    }
}
