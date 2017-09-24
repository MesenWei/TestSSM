package com.demo.java.java8.lambda;

import java.util.Date;
import java.util.Optional;

/**
 * Optional类
 * Optional 不是接口而是一个类，这是个用来防止NullPointerException异常的辅助类型
 * Optional 被定义为一个简单的容器，其值可能是null或者不是null。
 * 在Java8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，而在Java 8中，不推荐你返回null而是返回Optional。
 * 这是一个可以为null的容器对象。
 * 如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 *
 * Created by maosheng on 2017/9/12.
 */
public class Test4ForOptional {
    /**
     * 会报错，of方法不允许传入null
     */
    //Optional opt = Optional.of(null);

    Optional opt1 = Optional.of("hello");

    /**
     * ofNullable方法允许传入null值。
     */
    Optional opt2 = Optional.ofNullable(null);

    public void a(){
        //System.out.println(opt);
        System.out.println(opt1);
        System.out.println(opt2);
    }

    public void isPresent(){
        if(opt1.isPresent()){
            System.out.println(opt1.get());
        }
        if(opt2.isPresent()){
            System.out.println("opt2 is not null:" + opt2.get());
        }else {
            System.out.println("opt2 is null");
        }
    }

    public void ifPresent(){
        opt1.ifPresent(str -> System.out.println(str));
        opt2.ifPresent(System.out::print);
    }

    public void orElse(){
        System.out.println(opt1.orElse("hello !!!"));
        System.out.println(opt2.orElse("this is hello!"));
    }

    public void orElseGet(){
        System.out.println(opt1.orElseGet(() -> new Date()));
        System.out.println(opt2.orElseGet(() -> new Date()));
    }

    public void orElseThrow(){
        try {
            opt1.orElseThrow(()->new Exception());
            opt1.orElseThrow(Exception::new);
            opt2.orElseThrow(Exception::new);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main (String[] org0){
        Test4ForOptional test4ForOptional = new Test4ForOptional();
        //test4ForOptional.a();
        //test4ForOptional.isPresent();
        //test4ForOptional.orElse();
        test4ForOptional.orElseGet();
    }

}
