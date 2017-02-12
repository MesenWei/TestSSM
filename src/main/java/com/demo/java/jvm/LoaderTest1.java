package com.demo.java.jvm;

/**
 * Created by mesen on 2016/12/29.
 */
public class LoaderTest1 {
    public LoaderTest1(){
        System.out.println("A");
    }
    {
        System.out.println("clsA");
    }
    static {
        System.out.println("staticA");
    }
}

class B extends LoaderTest1{
    public B(){
        System.out.println("B");
    }
    {
        System.out.println("clsB");
    }
    static {
        System.out.println("staticB");
    }

    public static void main(String[] arg0){
        System.out.println("1");
        new B();
        System.out.println("2");
    }
}


