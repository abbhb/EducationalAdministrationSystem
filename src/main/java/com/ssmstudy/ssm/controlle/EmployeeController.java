package com.ssmstudy.ssm.controlle;

import com.ssmstudy.ssm.Authorization.Authorization;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.pojo.Employee;
import com.ssmstudy.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Date 13点53分
 * @author qc200
 * Description:
 * 查询所有的员工信息-->/employee-->get
 * 查询员工信息（分页）-->/employee/page/-->get
 * 根据员工id查询员工信息-->/employee/1-->get
 * 跳转添加页面-->/to/add-->get
 * 添加员工信息-->/employee->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee-->delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page",method = RequestMethod.GET)
    @ResponseBody
    public DataResult getEmployeePage(@RequestParam(name = "pageNum", required = true)Integer pageNum,@RequestParam(name = "pageSize", required = true)Integer pageSize){
        System.out.println(pageNum+"ddd"+pageSize);
        return employeeService.getEmployeePage(pageNum,pageSize);
    }
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    @Authorization
    @ResponseBody
    public DataResult getAllEmployee(){
        //查询所有的员工信息
        DataResult dataResult = employeeService.getAllEmployee();
        return dataResult;
    }
}
