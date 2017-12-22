package com.lyjsh.common;

/**
 * @Author wl
 * @Date 2017/12/21 23:57
 * @Todo 通用结果返回封装
 */
public class ExecuteResult {

    //操作成功
    public static final int EXE_SUCCESS = 200;

    //系统内部错误
    public static final int SYS_ERROR = 500;

    //参数错误
    public static final int PARAM_ERROR = 400;

    //操作的数据未找到
    public static final int DATA_NOT_FOUNT = 404;

    //业务校验错误
    public static final int BUSSINESS_ERROR = 407;

    public static final int OPRATE_FAULT = 405;

    private int code;

    private String msg;

    private Object data;

    public ExecuteResult() {

    }

    public ExecuteResult (int code,String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.data = result;
    }

   public static ExecuteResult success(Object result) {
        return new ExecuteResult(EXE_SUCCESS,"操作成功",result);
   }

   public static ExecuteResult success() {
        return new ExecuteResult(EXE_SUCCESS,"操作成功",null);
   }

   //系统错误
   public static ExecuteResult error() {
        return new ExecuteResult(SYS_ERROR,"系统内部错误",null);
   }

   //参数错误
    public static ExecuteResult validateError(String msg,Object data) {
        return new ExecuteResult(PARAM_ERROR,msg,data);
    }

    //业务校验错误
    public static ExecuteResult bussError(String msg,Object data) {
        return new ExecuteResult(BUSSINESS_ERROR,msg,data);
    }

    public static ExecuteResult oprateFault(String msg,Object data) {
        return new ExecuteResult(OPRATE_FAULT,msg,data);
    }
}
