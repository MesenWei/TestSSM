package com.demo.java.Exception;

/**
 * 自定义异常：
 *          总是执行完所有方法才会输出错误信息
 * Java异常：
 *          执行到异常处即输出错误信息然后继续执行
 * 不知道是什么原因。
 *
 * Created by Administrator on 2016/11/17.
 */
public class TestMyException {
    public static void a() throws MyException {
        throw new MyException("aaa");
    }

    public static String b(){
        String a = "1";
        try {
            a();
            System.out.println("b1");
        } catch (MyException e) {
            System.out.println("cause:"+e.getMessage());
            a = "2";
            return a;
        }
        System.out.println("b2");
        return "3";
    }

    public static void c(){
        try{
            System.out.println("c1");
            throw new MyException("ccccccccc");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("c2");
        }finally {
            System.out.println("c3");
        }
    }


    public static void main(String[] args){
        System.out.println(b());
    }
}
