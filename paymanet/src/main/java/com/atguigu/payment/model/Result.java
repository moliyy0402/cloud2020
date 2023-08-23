package com.atguigu.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

import static com.atguigu.payment.model.ResultCode.*;


/**
 * 统一返回结果
 * @author moli
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>   implements Serializable {
    private Integer code;

    private String message;

    private T data;


    public static <T> Result<T> error() {
        return new Result<>(FAILURE.getCode(), FAILURE.getDesc(), null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(FAILURE.getCode(), message, null);
    }

    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> success() {
        return new Result<>(SUCCESS.getCode(), SUCCESS.getDesc(), null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS.getCode(), SUCCESS.getDesc(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> success(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> success(Integer code, String message) {
        return new Result<>(code, message, null);
    }

}

