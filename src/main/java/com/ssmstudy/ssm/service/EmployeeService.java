package com.ssmstudy.ssm.service;

import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult getAllEmployee();

    DataResult getEmployeePage(int pageNum,int pageSize);
}
