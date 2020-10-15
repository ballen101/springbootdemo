package com.example.demo.dto;

import com.example.demo.enums.ResultEnum;

import java.io.Serializable;

public class ResultVO<T>{
    private int code;
    private T data;
    private String message;

    public ResultVO(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResultVO(){

    }

    public static <T> ResultVO<T> success(T data){
        return new ResultVO<T>(ResultEnum.SUCCESS.getCode(),data, ResultEnum.SUCCESS.getMsg());
    }

    public static <T> ResultVO<T> success(){
        return new ResultVO<>(ResultEnum.SUCCESS.getCode(),null, ResultEnum.SUCCESS.getMsg());
    }

    public static <T> ResultVO<T> success(String msg){
        return new ResultVO<>(ResultEnum.SUCCESS.getCode(),null,msg);
    }

    public static <T> ResultVO<T> success(T data,String msg){
        return new ResultVO<>(ResultEnum.SUCCESS.getCode(),data,msg);
    }

    public static <T> ResultVO<T> failed(){
        return new ResultVO<>(ResultEnum.ERROR.getCode(),null, ResultEnum.ERROR.getMsg());
    }

    public static <T> ResultVO<T> failed(String msg){
        return new ResultVO<>(ResultEnum.ERROR.getCode(),null,msg);
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }


}
