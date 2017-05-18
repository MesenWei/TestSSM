package com.demo.java.annotation.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Retention 用于对注解进行解释说明：被加了Retention注解的注解会被保留到那个阶段。
 * Created by maosheng on 2017/5/18.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
    String doTestRetention();
}