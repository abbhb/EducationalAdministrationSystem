package com.ssmstudy.ssm.controlle;

import com.ssmstudy.ssm.Authorization.NeedToken;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.service.IRedisService;
import com.ssmstudy.ssm.service.UserService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * (*)为needToken
 * 登录-->/login-->post
 * 手动检验token-->/login/checktoken-->post
 * (*)安全退出（手动删除token）-->/logout-->get
 * (*)更新用户信息-->/updataforuser-->post
 * (*)修改用户密码-->/user/changepassword-->post
 *
 */
@Controller
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private IRedisService iRedisService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public DataResult login(@RequestBody Map<String, Object> user){
        String username = (String) user.get("username");
        String password = (String) user.get("password");
        DataResult dataResult = userService.login(username,password);
        return dataResult;
    }
    @RequestMapping(value = "/login/checkToken",method = RequestMethod.GET)
    @ResponseBody
    public DataResult checkToken(@RequestHeader(value="Authorization", defaultValue = "") String token){
        DataResult dataResult = userService.checkToken(token);
        return dataResult;
    }

    @NeedToken
    @RequestMapping(value = "/login/logout",method = RequestMethod.GET)
    @ResponseBody
    public DataResult loginOut(@RequestHeader(value="Authorization", defaultValue = "") String token){
        DataResult dataResult = userService.deleteToken(token);
        return dataResult;
    }

    @RequestMapping(value = "/updataforuser",method = RequestMethod.POST)
    @ResponseBody
    @NeedToken
    public DataResult updataForUser(@RequestHeader(value="Authorization", defaultValue = "") String token, @RequestBody Map<String, Object> user){

        String name = (String) user.get("name");
        Integer age = Integer.valueOf((String) user.get("age")+"");
        String gender = (String) user.get("gender");
        String email = (String) user.get("email");
        DataResult dataResult = userService.updataForUser(token,name,age,gender,email);
        return dataResult;
    }

    @RequestMapping(value = "/user/changepassword",method = RequestMethod.POST)
    @ResponseBody
    @NeedToken
    public DataResult changePassWord(@RequestHeader(value="Authorization", defaultValue = "") String token, @RequestBody Map<String, Object> user){
        Integer id = (Integer) user.get("id");
        String username = (String) user.get("username");
        String password = (String) user.get("password");
        String newpassword = (String) user.get("newpassword");
        String checknewpassword = (String) user.get("checknewpassword");
        return userService.changePassWord(id,username,password,newpassword,checknewpassword,token);
    }
}
