package com.demo.java.java8.utils;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by maosheng on 2017/9/18.
 */
public class CollectorsTest {
    public static void a(){
        List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
        List<String> result = list.stream().filter(s->s.length()>4).collect(Collectors.toList());
    }

    public static void b(){
        List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::length));
        Map<Boolean, List<String>> collect2 = list.stream().collect(Collectors.groupingBy(str->str.contains("c")));
        System.out.println(JSON.toJSONString(collect));
        System.out.println(JSON.toJSONString(collect2));
    }

    public static void main (String[] org0){
        a();
        b();
    }
}
