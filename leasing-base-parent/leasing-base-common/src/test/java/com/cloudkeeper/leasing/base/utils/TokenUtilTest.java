package com.cloudkeeper.leasing.base.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class TokenUtilTest {

    @Test
    public void of() {
        String token = TokenUtil.of("002c84fe-81e5-4ae5-9aad-b1d97f827962");
        assertNotNull(token);
    }

    @Test
    public void parseJWT() {
        String id = "002c84fe-81e5-4ae5-9aad-b1d97f827962";
        String token = TokenUtil.of(id, 10000L);
        log.info("token:" + token);
        token = "123";
        Claims claims = null;
        try {
            claims = TokenUtil.parseJWT(token);
        } catch (ExpiredJwtException e) {
            log.error("token失效，请重新登录");
            assertNotNull(claims);
        } catch (Exception e) {
            log.error("token令牌错误");
            assertNotNull(claims);
        }
        assertEquals(claims.getId(), id);
    }
}