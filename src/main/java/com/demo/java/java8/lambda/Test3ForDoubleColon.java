package com.demo.java.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 方法与构造函数引用 Method references。
 * 返回值：函数式接口。
 *
 * Created by maosheng on 2017/9/18.
 */
public class Test3ForDoubleColon {
    static List<String> features = Arrays.asList("Lambdas", "Default Method","Default Method", "Stream API", "Date and Time API");

    /**
     * Java 8 允许你使用 :: 关键字来引用方法(静态方法和非静态方法).
     * Classname::methodName
     *
     * Java 8 允许你使用 :: 关键字来引用构造函数
     */
    public static void doubleColon(){
        /**
         * 引用静态方法：比较简单，没有太多限制。
         *
         * 引用成功的条件：
         *      1.方法接受者必须是在函数式接口中。
         *      2.引用的方法的参数必须与抽象方法的参数一致。
         *
         * 此函数式接口的抽象方法引用了Integer中的toBinaryString方法。
         */
        Apple apple = Integer::toBinaryString ;
        String run = apple.run(2);
        System.out.println(run);
        System.out.println("------------------");

        /**
         * 引用非静态方法：有很多限制条件。
         *      1.通过对象的引用（变量名）进行方法引用。此时，泛型必须明确。
         *      2.通过对象直接进行方法引用。
         *        成功条件：
         *          1.函数式接口必须是接受泛型的。
         *          2.接受的泛型的类型必须与被引用的方法的类一致。
         *          2.被引用的方法必须是无参方法。
         *
         * 通过2的实验，可以看出，个人认为：
         * 1.没有体现出这种使用方式的任何优点。
         * 2.可能在封装类的时候用一下比较好，挺装逼的。
         * 3.当然也可能比原来的用法效率更高。
         */
        //1.
        String str = "abc";
        Predicate<String> p1 = str::contains;
        System.out.println(p1.test("a"));
        System.out.println("------------------");

        //2.1
        Action<Model> action = Model::test1;
        action.run(new Model());

        //2.2
        //Action<Model> action2 = Model::test2;//非静态方法引用失败，因为test2方法有参数。

        //2.3
        Action<Model> action3 = Model::test3;
        //int a = action.run(new Model());//接受返回值报错，说明，方法的引用其实是引用的方法体，参数和返回值都没有被引用。

        //2.4
        //Apple apple1 = Model::test4;//非静态方法引用失败，因为Apple没有泛型。
        System.out.println("------------------");

        /**
         * 引用构造方法
         * 引用类的构造器，类中可能有很多构造器，具体引用的哪一个取决于函数式接口的抽象方法的参数。
         *
         * TODO 只是会用，不知道其应用场景是什么。
         */
        Action2 a = Model::new;
        Model model = a.run();
        model.test1();
    }

    public static void doubleColonInsteadLambda(){
        List<String> collect = features.parallelStream().filter(s -> s.contains("a")).collect(Collectors.toList());
        List<String> collect2 = features.parallelStream().filter(Model::test5).collect(Collectors.toList());

        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::print);
    }

    public static void main (String[] org0){
        doubleColon();
        doubleColonInsteadLambda();
    }
}
