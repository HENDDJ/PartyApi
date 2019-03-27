package com.cloudkeeper.leasing.config;

import com.cloudkeeper.leasing.base.annotation.Authorization;
import com.cloudkeeper.leasing.base.constant.AuthorizationConstants;
import com.cloudkeeper.leasing.base.utils.TokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger2.web.Swagger2Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * token 拦截器
 * @author jerry
 */
@Slf4j
@Component
public class AccessTokenInterceptor implements HandlerInterceptor {

    /** redis 数据库操作模板类*/
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)
                || ((HandlerMethod) handler).getBean() instanceof ApiResourceController
                || ((HandlerMethod) handler).getBean() instanceof Swagger2Controller) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Authorization authorization = method.getAnnotation(Authorization.class);
        if (authorization != null && !authorization.required()) {
            //过滤不拦截的方法
            return true;
        }
        //从header中得到token
        String token = request.getHeader(AuthorizationConstants.AUTHORIZATION);
        if (!StringUtils.hasText(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        Claims claims;
        try {
            claims = TokenUtil.parseJWT(token);
        } catch (ExpiredJwtException expiredJwtException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.warn("token 过期了");
            return false;
        } catch (Exception exception) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.warn("无效 token");
            return false;
        }
        String principalId = claims.getId();
        String token2 = redisTemplate.opsForValue().get(AuthorizationConstants.REDIS_TOKEN_KEY + principalId);
        if (!token.equals(token2)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("用户不存在或已失效，请重新登录");
            return false;
        }
        request.getSession().setAttribute(AuthorizationConstants.CURRENT_USER_ID, principalId);
        return true;
    }
}
