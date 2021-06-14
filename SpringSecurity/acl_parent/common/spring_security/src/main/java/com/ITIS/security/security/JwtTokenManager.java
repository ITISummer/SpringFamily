package com.ITIS.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 使用 jwt 生成 token
 */
@Component
public class JwtTokenManager {
    //token有效时长
    private long tokenEncryption = 24*60*60*1000;
    //编码秘钥
    private String tokenSignKey = "ITIS.com";

    /**
     * 使用jwt根据用户名生成token
     * @param username
     * @return
     */
    public String createToken(String username) {
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ tokenEncryption))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    /**
     * 根据token字符串得到用户信息
      * @param token
     * @return
     */
    public String getUserInfoFromToken(String token) {
        String userInfo = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return userInfo;
    }

    /**
     * 删除token
     * @param token
     */
    public void removeToken(String token) { }
}
