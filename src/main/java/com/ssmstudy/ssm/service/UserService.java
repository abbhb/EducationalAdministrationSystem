package com.ssmstudy.ssm.service;

import com.ssmstudy.ssm.pojo.DataResult;

public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    DataResult login(String username, String password);

    /**
     * 检验token
     * @param token
     * @return
     */
    DataResult checkToken(String token);

    /**
     * 删除token
     * @param token
     * @return
     */
    DataResult deleteToken(String token);

    /**
     * 更新用户信息
     * @param name
     * @param age
     * @param gender
     * @param email
     * @return
     */
    DataResult updataForUser(String token,String name, Integer age, String gender, String email);




    /**
     * 修改密码
     * @param id
     * @param username
     * @param password
     * @param newpassword
     * @param checknewpassword
     * @param token
     * @return
     */
    DataResult changePassWord(Integer id, String username, String password, String newpassword, String checknewpassword,String token);
}
