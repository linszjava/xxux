package com.lin.xxux.common.utils.jwt;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;
import java.util.Date;

/**
 * <p>TODO</p>
 * @version v1.0
 * @date 2023/12/31 17:51
 * @see  com.lin.xxux.common.utils.jwt.JwtHelper
 * @since 2023/12/31 17:51
 * @description  publicKey + InfoJson + saltIP(secretKey) = token
 */
public class JwtHelper {

    private static final long tokenExpiration = 365L *24*60*60*1000;
    private static final String tokenSignKey = "xxux";

    //根据userId+userName生成token字符串
    public static String createToken(Long userId, String userName) {
        return Jwts.builder()
                .setSubject("xxux-USER")

                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))

                .claim("userId", userId)
                .claim("userName", userName)

                .signWith(SignatureAlgorithm.HS512, tokenSignKey)

                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    public static Long getUserId(String token) {
        if(StringUtils.isEmpty(token)) return null;

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer)claims.get("userId");
        return userId.longValue();
        // return 1L;
    }

    public static String getUserName(String token) {
        if(StringUtils.isEmpty(token)) return "";

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("userName");
    }

    public static void removeToken(String token) {
        //jwttoken无需删除，客户端扔掉即可。
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken(1888L, "admin");
        System.out.println(token);

        System.out.println(JwtHelper.getUserId(token));
        System.out.println(JwtHelper.getUserName(token));
    }
}
