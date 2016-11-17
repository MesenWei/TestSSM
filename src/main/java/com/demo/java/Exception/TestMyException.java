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
    Object o;
    public void test1() {
        try {
            System.out.println("方法开始执行");
//            o.equals("");
            if(null == o)
                throw new MyException("Object 对象为null！");
            System.out.println("方法执行结束");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void test2(){
        System.out.println("test2 start");
    }
    public static void main(String[] args){
        new TestMyException().test1();
        System.out.println("main执行结束");
        new TestMyException().test2();

    }
}
