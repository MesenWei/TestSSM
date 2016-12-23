package com.demo.java.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */
public class Concurrent {
    public static void main(String[] args) {
//        a();
        b();
    }

    public static void a(){
        ConcurrentTest test1 = new ConcurrentTest();
        ConcurrentTest test2 = new ConcurrentTest();
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test1);


        t1.start();
        t2.start();
        System.out.println("**************两个线程已启动****************");
    }

    public static void b(){
        ConcurrentTest2 test1 = new ConcurrentTest2();
        ConcurrentTest2 test2 = new ConcurrentTest2();

        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test1);

        t1.start();
        t2.start();
    }
}

/**
 * 多个线程同时访问a方法：
 *      方式1.list未成员变量，随类存放在同一内存中（本次测试中，是一个对象的两个线程，如果两个对象，就要另做比较了。），
 *          多线程访问的时候，从内存中取出进行操作，因为多个线程操作的是同一个变量，那么会出现数据问题。即便是重新new了一下，
 *          但仍是同一对象。
 *
 *      方式2.list为局部变量，不是随着类放在内存中了，而是根据线程，另开辟了一块内存进行存储，那么不同线程操作不同变量，
 *          则不会出现数据问题。
 *
 *      总结：
 *      方法内的局部变量是随着线程走的（即便是同一个对象），每一个线程单独处理局部变量，局部变量不共享。（todo 局部变量的存储位置和方式）
 */
class ConcurrentTest implements Runnable{
    static String[] str1 = {"a","b","c","d","e","f","g","h","i","g"};

    static String[] str2 = {"0","1","2","3","4","5","6","7","8","9"};

    static Boolean b = false;

    List<String> list = new ArrayList<>();//1.

    public List<String> a() throws InterruptedException {
//        list = new ArrayList<>();//1.
        List<String> list = new ArrayList<>();//2.

        String abc = String.valueOf(b);
        System.out.println("hashcode:"+abc.hashCode()+"***"+abc);
        if(b){
            b = false;
            for(int i=0;i<10;i++){
                list.add(str1[i]);
                System.out.println("第一个添加了一个字母"+str1[i]);
                Thread.sleep(500);
            }
            System.out.println("第一个添加了一个字母"+abc);
            list.add(abc);
        }else {
            b = true;
            for(int i=0;i<10;i++){
                list.add(str2[i]);
                System.out.println("第二个添加了一个数字"+str2[i]);
                Thread.sleep(500);
            }
            System.out.println("第一个添加了一个字母"+abc);
            list.add(abc);
        }

        return list;
    }

    @Override
    public void run() {
        try {
            List<String> list = a();
            System.out.println("=========="+list+"==========");
            for (String str : list){
                System.out.println(str);
            }
            System.out.println("=========="+list+"==========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ConcurrentTest2 implements Runnable{
    boolean b = true;

        String str ;
    public String a() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"先进入的a方法");
        if(b){
            b = false;
            str = "aaaaaaaaaaaa";
            System.out.println("str的值为"+str);
            Thread.sleep(2000);
        }else {
            b = true;
            str = "bbbbbbbbbbbb";
            System.out.println("str的值为"+str);
            Thread.sleep(1000);
        }
        System.out.println("最终值"+str);
        return str;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+a());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}