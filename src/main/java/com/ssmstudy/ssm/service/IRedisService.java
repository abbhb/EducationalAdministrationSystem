package com.ssmstudy.ssm.service;

import com.ssmstudy.ssm.pojo.User;

/**
 * redis相关的业务
 */
public interface IRedisService {


    /**
     * 校验token
     * @param token
     * @return
     */
    boolean checkToken(String token);

    /**
     * 通过token从redis获取user对象
     * @param token
     * @return
     */
    User getUserByToken(String token);

    /**
     * setRedis的value，key为token
     * @param token
     */
    void setUserByToken(String token,User user);

    /**
     * 删除redis键值对
     * @param token
     */
    void delUserByToken(String token);

}
