package com.demo.java.annotation.retention;

public class RetentionTest {
    @A(doTestRetention = "abac")
    public static void doSomething() {
        System.out.println("hello world");
    }

    public static void main(String[] org0) {
        RetentionTest.doSomething();
    }
}