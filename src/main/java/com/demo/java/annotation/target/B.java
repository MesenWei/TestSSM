package com.demo.java.annotation.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target用于解释说明注解的作用目标：即注解可以加到那些目标上，类、属性、方法...？
 * 次测试中表明B这个注解只能加在属性和参数上面，如果加在方法上面，代码运行时期就会报错。
 * Created by maosheng on 2017/5/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface B {
}
