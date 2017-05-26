package com.demo.java.extendtest;

/**
 * Created by maosheng on 2017/5/24.
 */
public class Son extends Father{
    public void a(){
        System.out.println("Son---a");
    }

    public void b(){
        System.out.println("Son---b");
    }

    public void c(){

    }
    public static void main (String[] org0){
        Father father = new Son();

    }
}
