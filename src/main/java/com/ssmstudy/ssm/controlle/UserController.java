package com.ssmstudy.ssm.controlle;

import com.ssmstudy.ssm.Authorization.NeedToken;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 登录-->/login-->post
 * 手动检验token-->/login/checktoken-->post
 * 安全退出（手动删除token）-->/logout-->get
 */
@Controller
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

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
    @NeedToken
    @RequestMapping(value = "/updataforuser",method = RequestMethod.POST)
    @ResponseBody
    public DataResult updataForUser(@RequestBody Map<String, Object> user,@RequestHeader(value="Authorization", defaultValue = "") String token){
        String name = (String) user.get("name");
        Integer age = Integer.valueOf((String) user.get("age"));
        String gender = (String) user.get("gender");
        String email = (String) user.get("email");
        DataResult dataResult = userService.updataForUser(token,name,age,gender,email);
        return dataResult;

    }
}
