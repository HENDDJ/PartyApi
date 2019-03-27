package com.cloudkeeper.leasing.base.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * token 工具类
 * @author jerry
 */
public class TokenUtil {

    /** 签名秘钥*/
    private static final String SECRET = "CloudKeeper";

    /** 签发者*/
    private static final String ISSUER = "www.cloudkeeper.com";

    /** 用户*/
    private static final String SUBJECT = "service@cloudkeeper.cn";

    /** token有效期，3600000 为一个小时*/
    public static final long TTL_MILLIS = 3600000 * 10;

    /**
     * 生成token
     * @param id 一般是userId
     * @return token
     */
    public static String of(@Nonnull String id) {
        return of(id, null);
    }

    /**
     * 生成token
     * @param id 一般是userId
     * @param ttlMillis 签发时间 （有效时间，过期会报错）
     * @return token
     */
    public static String of(@Nonnull String id, Long ttlMillis) {
        return of(id, ISSUER, SUBJECT, ttlMillis);
    }

    /**
     * 生成Token
     * @param id        编号
     * @param issuer    该JWT的签发者，是否使用是可选的 例如：www.xxxx.com
     * @param subject   该JWT所面向的用户，是否使用是可选的；例如：xxxx@163.com
     * @param ttlMillis 签发时间，（过期毫秒数） （有效时间，过期会报错）
     * @return token String
     */
    public static String of(@Nonnull String id, String issuer, String subject, Long ttlMillis) {
        if (ttlMillis == null) {
            ttlMillis = TTL_MILLIS;
        }
        // 签名算法 ，将对token进行签名
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 通过秘钥签名JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now);
        if (StringUtils.hasText(issuer)) {
            builder.setIssuer(issuer);
        }
        if (StringUtils.hasText(subject)) {
            builder.setSubject(subject);
        }
        builder.signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();

    }

    // Sample method to validate and read the JWT

    /**
     * Sample method to validate and read the JWT
     * @param jwt token
     * @return claims
     */
    public static Claims parseJWT(String jwt) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        // This line will throw an exception if it is not a signed JWS (as expected)
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET)).parseClaimsJws(jwt).getBody();
    }

}
