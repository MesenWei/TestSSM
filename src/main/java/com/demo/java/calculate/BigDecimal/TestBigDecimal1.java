package com.demo.java.calculate.BigDecimal;

import java.math.BigDecimal;

/**
 * Created by maosheng on 2017/6/15.
 */
public class TestBigDecimal1 {
    public static void main (String[] org0){
        BigDecimal bigDecimal = new BigDecimal("6");
        System.out.println(bigDecimal.add(new BigDecimal("0.666")));
    }
}
