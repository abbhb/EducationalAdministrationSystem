package com.ssmstudy.ssm.utils;

import com.auth0.jwt.JWTVerifier;


import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ssmstudy.ssm.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWT {
    /**
     * token加密时使用的密钥
     * 一旦得到该密钥也就可以伪造token了
     */
    public static final String SUBJECT = "MyfHHAJSD334d";
    public static final String sercetKey = "MyfHHAJSD334d";
    /**
     * 代表token的有效时间
     */
    public final static long keeptime = 1800000;

    /**
     * JWT由3个部分组成,分别是 头部Header,载荷Payload一般是用户信息和声明,签证Signature一般是密钥和签名
     * 当头部用base64进行编码后一般都会呈现eyJ...形式,而载荷为非强制使用,签证则包含了哈希算法加密后的数据,包括转码后的header,payload和sercetKey
     * 而payload又包含几个部分,issuer签发者,subject面向用户,iat签发时间,exp过期时间,aud接收方。
     * @Title: generToken
     * @Description: TODO
     * @param: @param id 用户id
     * @param: @param issuer 签发者
     * @param: @param subject 一般用户名
     * @param: @return
     * @return: String
     * @throws
     */
    public static String generToken(User user) {

        String token = Jwts.builder().setSubject(sercetKey)
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .claim("password", user.getPassword())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + keeptime))
                .signWith(SignatureAlgorithm.HS256, SUBJECT).compact();
        return token;
    }
    /**
     * 该函数用于更新token
     * @Title: updateToken
     * @Description: TODO
     * @param: @param token
     * @param: @return
     * @return: String
     * @throws
     */

    /**
     * 将token解密出来,将payload信息包装成Claims类返回
     * @Title: verifyToken
     * @Description: TODO
     * @param: @param token
     * @param: @return
     * @return: Claims
     * @throws
     */
    public static Claims checkJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(sercetKey).parseClaimsJws(token).getBody();
        return claims;
    }

}
