package com.ddv.hyh.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

//保证序列化json的时候,如果是null的对象,key也会消失
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse<T> implements Serializable {
    // 响应状态码
    private int code;
    // 响应信息
    private String msg;
    // 响应数据
    private T data;

    public ServiceResponse(int code) {
        this.code = code;
    }

    public ServiceResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ServiceResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceResponse(int code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <T> ServiceResponse<T> createBySuccess() {
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServiceResponse<T> createBySuccess(T data) {
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServiceResponse<T> createBySuccess(String msg, T data) {
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServiceResponse<T> createBySuccessMessage(String msg) {
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServiceResponse<T> createByError() {
        return new ServiceResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServiceResponse<T> createByErrorMessage(String msg) {
        return new ServiceResponse<T>(ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> ServiceResponse<T> createByErrorCodeMessage(int code, String msg) {
        return new ServiceResponse<T>(code, msg);
    }
}
