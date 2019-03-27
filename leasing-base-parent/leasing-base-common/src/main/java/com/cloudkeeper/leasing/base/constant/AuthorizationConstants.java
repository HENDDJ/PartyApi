package com.cloudkeeper.leasing.base.constant;

/**
 * 身份认证常量
 * @author jerry
 */
public class AuthorizationConstants {

    /** 存储当前登录用户id的字段名*/
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /** 存储当前登录用户id的字段名*/
    public static final String REDIS_TOKEN_KEY = "identity:token:principalId:";

    /** 存储当前登录用户的字段名*/
    public static final String CURRENT_USER = "CURRENT_USER";

    /** token有效期（小时）*/
    public static final int TOKEN_EXPIRES_HOUR = 72;

    /** 认证字段*/
    public static final String AUTHORIZATION = "authorization";
}
