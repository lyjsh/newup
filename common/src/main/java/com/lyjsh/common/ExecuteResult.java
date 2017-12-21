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

    //业务校验不通过的错误
    public static final int BUSSINESS_ERROR = 407;

    private int code;

    private String msg;

    private Object result;

    public ExecuteResult() {

    }

    public ExecuteResult (int code,String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

   public static ExecuteResult success(Object result) {
        return new ExecuteResult(EXE_SUCCESS,"操作成功",result);
   }

   public static ExecuteResult success() {
        return new ExecuteResult(EXE_SUCCESS,"操作成功",null);
   }
}
