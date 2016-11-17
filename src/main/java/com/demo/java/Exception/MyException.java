package com.demo.java.Exception;

/**
 * Created by Administrator on 2016/11/17.
 */
public class MyException extends Exception{
    public MyException(String msg){
        super(msg);
    }

    public MyException(String msg ,Throwable cause){
        super(msg,cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
