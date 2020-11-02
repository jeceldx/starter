package com.ldx.starter.util;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName:JwtUtil
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 10:12
 @Version 1.0
 */
public class JwtUtil {
    /**
     * 过期时间为一天
     * TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 24*60*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "joijsdfjlsjfljfljl5135313135";

    /**
     * 生成签名,15分钟后过期
     * @param username
     * @param passWord
     * @return
     */
    public static String sign(String username,String passWord){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim("loginName",username)
                .withClaim("passWord",passWord).withExpiresAt(date).sign(algorithm);
//        .withHeader(map)// 设置头部信息 Header
//                .withIssuer("SERVICE")//设置 载荷 签名是有谁生成 例如 服务器
//                .withSubject("this is test token")//设置 载荷 签名的主题
//                // .withNotBefore(new Date())//设置 载荷 定义在什么时间之前，该jwt都是不可用的.
//                .withAudience("APP")//设置 载荷 签名的观众 也可以理解谁接受签名的
//                .withIssuedAt(nowDate) //设置 载荷 生成签名的时间
//                .withExpiresAt(expireDate)//设置 载荷 签名过期的时间
//                .sign(algorithm);//签名 Signatu
    }


    public static Map<String,Object> verity(String token){
        Map<String,Object> result=new HashMap<>();
        try {

            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            Map<String, Claim> claims = jwt.getClaims();
            for (Map.Entry<String, Claim> entry : claims.entrySet()) {
                String key = entry.getKey();
                Claim claim = entry.getValue();
                System.out.println("key:"+key+" value:"+claim.asString());
                result.put(key,claim.asString());
            }
            result.put("verify", true);
            return result;
        } catch (IllegalArgumentException e) {
            result.put("verity", false);
            return result;
        } catch (JWTVerificationException e) {
            result.put("verity", false);
            return result;
        }

    }
}
