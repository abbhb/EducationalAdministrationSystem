package com.ssmstudy.ssm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PassWordMD5 {

    public static String md5(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("utf-8"));
            byte[] digest = md5.digest();
            String s = new BigInteger(1,digest).toString(16);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //暂时没写，单向加密
    public static String passWordMD5JM(String password){
        System.out.println("password = " + PassWordMD5.md5(password));
        return PassWordMD5.md5(password);
    }
}
