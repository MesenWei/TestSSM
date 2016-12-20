package com.hailstone.bsms.model;

/**
 * 页面上使用的vo
 * Created by Administrator on 2016/12/20.
 */
public class ViewObject<T> {
    private Integer     status;
    private String      msg;
    private T           data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
