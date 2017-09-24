package com.demo.java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * lambad基本用法。
 * 返回值：函数式接口。
 *
 * 函数式接口：只有一个显示抽象方法的接口叫函数式接口。
 * lambda表达式只适用于函数式接口。
 *
 * Created by maosheng on 2017/9/12.
 */
public class Test1ForLambda {
    public void a(){
        //java8之前
        testA(new A() {
            @Override
            public int a(int x, int y) {
                return x + y;
            }
        });

        //java8之后的lambda
        /*
          共有三种方式
          (params) -> expression
          (params) -> statement
          (params) -> { statements }
         */
        testA((x,y) -> x + y);
        testA((int x,int y) -> x - y);
        testA((int x,int y) -> {return x * y;});
        testA((int x,int y) -> 42);
    }

    public void testA(A a){
        int temp = a.a(1,2);
        System.out.println(temp);
    }

    public void testB(B b){
        A a = (x,y) -> x+y ;//OK!

        //Object o1 = (x,y) -> x+y ;//ERROR! Object is not a functional interface!

        Object o2 = a;//OK!

        Object o3 = (A)(x,y) -> x+y ;//OK!

        //System.out.println((x,y) -> x+y);//CORRECT! Target typing is unclear!

        System.out.println((A)(x,y) -> x+y);//OK!
    }

    /**
     * 1.lambda表达式不可以掩盖任何其所在上下文中的局部变量。
     * lambda表达式对值封闭，对变量开放。
     */
    public void testC(){
        //1.
        /*int i = 0;
        int sum = 0;
        for (int i = 1; i < 10; i += 1) { //这里会出现编译错误，因为i已经在for循环外部声明过了
            sum += i;
        }

        //2.
        List<String> list = Arrays.asList("Lambdas", "Default Method","Default Method", "Stream API", "Date and Time API");
        int sumSize = 0;
        list.forEach(e -> { sumSize = list.size(); }); // Illegal, close over values

        List<String> aList = new ArrayList();
        list.forEach(e -> { aList.add(e); }); // Legal, open over variables*/
    }

    /**
     * 理解
     */
    public void testD(){
        /**
         * lambda表达式类似回调函数。
         * 传入的filter的参数表象是lambda表达式，实质是一个函数式接口的匿名内部类，也可以说成传入了一个函数式接口。
         * 传入的函数式接口后，filter方法中某一步操作，就是调用传入函数式接口的方法，也就是Predicate的test方法。
         * 而函数式接口的方法是用lambda表达式来实现的，那么filter
         * 调用的方法就是lamdba表达式的 -> 右边的内容;
         * 传入的参数就是 -> 左边的内容。
         * 至于传的参数是什么，开始是谁也不知道的，因为函数式接口的方法是filter调用的，参数也是filter传的，所以程序员是不知道的，
         * 但是通过验证后得知，filter传的参数是集合的每一个元素。
         */

        //1.
        //泛型为String，是因为此filter的集合泛型为String
        Predicate<String> predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                String str = (String) o;
                return str.contains("D");
            }
        };
        Predicate<String> predicate2 = s -> s.contains("D");

        Test2ForStream.features.parallelStream().filter(predicate).forEach(s -> System.out.println(s));

        Test2ForStream.features.parallelStream().filter(predicate2).forEach(s -> System.out.println(s));

        //2.
        Test2ForStream.features.parallelStream().filter(s -> s.contains("D")).forEach(s -> System.out.println(s));
    }
}

//这个注解不加也可以,加上只是为了让编译器检查
@FunctionalInterface
interface A{
    int a(int x,int y);
}

/**
 * 函数式接口：只有一个显示抽象方法的接口叫函数式接口。
 * lambda表达式只适用于函数式接口。
 */
interface B{
    int a(int x,int y);
    void b();
}

