package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    // 成功返回（默认消息）
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    // 成功返回（自定义消息）
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    // 失败返回（默认消息）
    public static <T> Result<T> failure() {
        return new Result<>(500, "internal server error", null);
    }

    // 失败返回（自定义消息）
    public static <T> Result<T> failure(String message) {
        return new Result<>(500, message, null);
    }

    // 自定义状态码和消息
    public static <T> Result<T> of(int code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
