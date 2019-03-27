package com.cloudkeeper.leasing.base.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Nonnull;

/**
 *  返回值对象
 * @param <T> 泛型
 * @author jerry
 */
@Getter
@Setter
@ToString
public class Result<T> {

    /** 返回值编码*/
    private int code;

    /** 返回信息*/
    private String msg;

    /** 返回内容*/
    private T content;

    private Result(int code, String msg, T content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public Result() {
    }

    @Nonnull
    public static <T> Result<T> of(int code) {
        return new Result<>(code, null, null);
    }

    @Nonnull
    public static <T> Result<T> of(String msg) {
        return new Result<>(ResultCode.OK.code, msg, null);
    }

    @Nonnull
    public static <T> Result<T> of(T content) {
        return new Result<>(ResultCode.OK.code, null, content);
    }

    @Nonnull
    public static <T> Result<T> ofNotFound() {
        return new Result<>(ResultCode.OK.code, ResponseMessageConstants.NOT_FOUND, null);
    }

    @Nonnull
    public static <T> Result<T> ofLost() {
        return new Result<>(ResultCode.FAIL.code, ResponseMessageConstants.NOT_FOUND, null);
    }

    @Nonnull
    public static <T> Result<T> ofAddSuccess(T content) {
        return new Result<>(ResultCode.OK.code, ResponseMessageConstants.ADD_SUCCESS, content);
    }

    @Nonnull
    public static <T> Result<T> ofUpdateSuccess(T content) {
        return new Result<>(ResultCode.OK.code, ResponseMessageConstants.UPDATE_SUCCESS, content);
    }

    @Nonnull
    public static <T> Result<T> ofDeleteSuccess() {
        return new Result<>(ResultCode.OK.code, ResponseMessageConstants.DELETE_SUCCESS, null);
    }

    @Nonnull
    public static <T> Result<T> of(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    @Nonnull
    public static <T> Result<T> of(int code, T content) {
        return new Result<>(code, null, content);
    }

    @Nonnull
    public static <T> Result<T> of(String msg, T content) {
        return new Result<>(ResultCode.OK.code, msg, content);
    }

    @Nonnull
    public static <T> Result<T> of(int code, String msg, T content) {
        return new Result<>(code, msg, content);
    }

    @Getter
    public enum ResultCode {

        /** 登录失败*/
        LOGIN_FAIL(101, "登录失败"),

        /** 成功*/
        OK(200, "成功"),

        /** 失败*/
        FAIL(500, "失败"),

        /** 服务器错误*/
        SERVER_ERROR(500, "服务器错误"),

        ;
        /** 编码*/
        private int code;

        /** 描述*/
        private String msg;

        ResultCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

}
