package com.lyjsh.Exception;

/**
 * @Author wl
 * @Date 2017/12/22 22:33
 * @Todo 业务异常类
 */
public class BussException extends Exception{

    private Integer code;

    private String msg;

    public BussException(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
