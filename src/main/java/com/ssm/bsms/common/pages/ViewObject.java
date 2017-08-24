package com.ssm.bsms.common.pages;

/**
 * 页面上使用的vo
 * Created by Administrator on 2016/12/20.
 */
public class ViewObject<T> {
    private Integer     code;
    private String      msg;
    private T           data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
