package com.ssmstudy.ssm.utils;

import com.ssmstudy.ssm.service.impl.RedisService;

public class RedisUtils {
    public static boolean checkToken(RedisService redisService,String token){
        boolean b = redisService.hasKey(token);
        return b;
    }
    public static void deleteToken(RedisService redisService,String token){
        redisService.del(token);

    }
}
