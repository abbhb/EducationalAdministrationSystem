package com.ssmstudy.ssm.service.impl;

import com.ssmstudy.ssm.Const;
import com.ssmstudy.ssm.mapper.UserMapper;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.pojo.login.LoginResult;
import com.ssmstudy.ssm.pojo.User;
import com.ssmstudy.ssm.service.UserService;
import com.ssmstudy.ssm.utils.JWT;
import com.ssmstudy.ssm.utils.RedisUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisService redisService;
    @Override
    public DataResult login(String username, String password) {
        DataResult dataResult = new DataResult();
        try {
            System.out.println("username+\",\"+password = " + username+","+password);
            User user = userMapper.login(username,password);
            System.out.println(user);
            
            if (user.getId()!=null&&user.getUsername()!=null){
                dataResult.setMsg("登录成功!");//后续可以加上时间和对应欢迎语
                //在此处返回token
                String token = JWT.generToken(user);
                System.out.println(user.getId().intValue());
                redisService.set(token,user.getId().intValue(),3600l);
                Claims claims = JWT.checkJWT(token);
                System.out.println(claims);
                user.setToken(token);
                dataResult.setStatus(Const.ZHENGCHANG);
                dataResult.setData(user);
            }else {
                dataResult.setStatus(Const.TOKENGUOQI);
                dataResult.setMsg("请检查密码或者用户名是否有误!");
            }
            return dataResult;
        }catch (Exception e){
            dataResult.setMsg("请检查密码或者用户名是否有误!");
            dataResult.setStatus(Const.TOKENGUOQI);
            return dataResult;
        }




    }

    @Override
    public DataResult checkToken(String token) {
        DataResult dataResult = new DataResult();
        boolean b1 = redisService.hasKey(token);
        if (b1){
            dataResult.setMsg("");
            Integer o = (Integer) redisService.get(token);
            System.out.println(o.intValue()+":token");
            User user = userMapper.getUserById(o.intValue());
            dataResult.setData(user);
            dataResult.setStatus(Const.ZHENGCHANG);
        }else {
            dataResult.setStatus(Const.TOKENGUOQI);
        }
        return dataResult;
    }

    @Override
    public DataResult deleteToken(String token) {
        DataResult dataResult = new DataResult();
        RedisUtils.deleteToken(redisService,token);
        dataResult.setStatus(Const.QIANGZHICLEANLOCALTOKEN);
        dataResult.setMsg("安全退出成功!");
        return dataResult;
    }

    @Override
    public DataResult updataForUser(String token,String name, Integer age, String gender, String email) {
        Object id = redisService.get(token);
        DataResult dataResult = new DataResult();
        if (id!=null){
            int idd = (int) id;

            int i = userMapper.updataForUser(idd, name, age, gender, email);
            System.out.println(i+"更新");
            if (i==1){
                dataResult.setMsg("更新成功");
                dataResult.setStatus(Const.ZHENGCHANG);
            }

        }else{
            dataResult.setMsg("更新失败");
            dataResult.setStatus(Const.UPDATAERROR);
        }
        return dataResult;
    }
}
