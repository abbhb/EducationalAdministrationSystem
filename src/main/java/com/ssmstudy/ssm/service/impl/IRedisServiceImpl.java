package com.ssmstudy.ssm.service.impl;

import com.ssmstudy.ssm.pojo.User;
import com.ssmstudy.ssm.service.IRedisService;
import com.ssmstudy.ssm.utils.RedisUtil;
import com.ssmstudy.ssm.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class IRedisServiceImpl implements IRedisService {

    private RedisTemplate redisTemplate;

//    @Autowired
    public IRedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean checkToken(String token) {
        boolean tokenIsHave = false;
        try {
            Boolean aBoolean = redisTemplate.hasKey(token);
            if (aBoolean!=null){
                System.out.println(aBoolean);
                tokenIsHave = aBoolean.booleanValue();
                return tokenIsHave;
            }
            tokenIsHave =  false;


        } catch (Exception e) {
            e.printStackTrace();
            tokenIsHave =  false;
        }
        return tokenIsHave;
    }

    @Override
    public User getUserByToken(String token) {
        System.out.println("get了");
        try {
            Object o = redisTemplate.opsForValue().get(token);
            if (o!=null){
                User user= (User)o;
                System.out.println(user);
                return user;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setUserByToken(String token,User user) {
        try {
            /**
             * 笔记：最后那个TimeUnit.SECONDS不写的话会出现很多xe/0类似的东西，
             * 最后才是内容，在springxml配置里写了序列化配置就不用手写序列化方法了，
             * 实现序列化接口会自己序列化，获取的时候会自己序列化回来
             */
            redisTemplate.opsForValue().set(token, user, 3600L, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delUserByToken(String token) {
        try {
            redisTemplate.delete(token);
        }catch (Exception e){
            System.out.println("delUserByToken e = " + e);
        }

    }
}
