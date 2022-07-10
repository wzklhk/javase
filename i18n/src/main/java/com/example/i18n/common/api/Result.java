package com.example.i18n.common.api;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(ErrorCodeEnum e, T data) {
        this.code = e.getErrorCode();
        this.msg = e.getErrorMsg();
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public static <T> Result<T> status(ErrorCodeEnum code, T data) {
        return new Result<>(code, data);
    }

    public static <T> Result<T> error() {
        return new Result<>(ErrorCodeEnum.FAILURE, null);
    }

    public static <T> Result<T> ok() {
        return new Result<>(ErrorCodeEnum.SUCCESS, null);
    }

    public static <T> Result<T> data(T data) {
        return new Result<>(ErrorCodeEnum.SUCCESS, data);
    }
}
