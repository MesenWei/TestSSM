package com.demo.java.java8.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map类型不支持stream，不过Map提供了一些新的有用的方法来处理一些日常任务。  
 * Created by maosheng on 2017/9/19.
 */
public class Test1 {
    public static Map init(){
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<10; i++){
            //如果为null，则不会保存进去。
            map.putIfAbsent(i, "val_"+i);
        }
        return map;
    }

    public static void forEach(){
        Map<Integer, String> map = init();
        map.forEach((k,v) -> System.out.println(k + ":" + map.get(k)));
    }

    /**
     * 计算如果key存在修改。
     *
     * 如果key存在则计算对应的key，保存新的value，
     * 如果value为null，则对应的key将被删除。
     */
    public static void computeIfPresent(){
        Map<Integer, String> map = init();
        map.computeIfPresent(3,(k,v) -> k+v);
        map.computeIfPresent(5,(k,v) -> null);
        map.forEach((k,v) -> System.out.println(k + ":" + map.get(k)));
    }

    /**
     * 计算如果key不存在新增。
     *
     * 如果key不存在，则新增一条数据，value不能为null。
     */
    public static void computeIfAbsent(){
        Map<Integer, String> map = init();
        map.computeIfAbsent(3,k -> "abc");
        map.computeIfAbsent(23,k -> "abc");
        map.computeIfAbsent(24,k -> null);
        map.forEach((k,v) -> System.out.println(k + ":" + map.get(k)));
    }

    public static void remove(){
        Map<Integer, String> map = init();
        map.remove(3);//ok
        map.remove(4,"a");//no
        map.remove(5,"val_5");//ok
        map.forEach((k,v) -> System.out.println(k + ":" + map.get(k)));
    }

    public static void getOrDefault(){
        Map<Integer, String> map = init();
        System.out.println(map.getOrDefault(44, "404 not found"));
    }

    public static void main (String[] org0){
        //forEach();
        //computeIfPresent();
        //computeIfAbsent();
        //remove();
        getOrDefault();
    }

    public static void a(){
        Map<Integer, String> map = init();

        //----------4--------其他一些帮助性方法：
        map.getOrDefault(44, "404 not found");

        //---------------5----------------合并map中的实体
        //此时map.get(9)=null
        map.merge(9, "val999", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val999
        System.err.println(map.get(9));

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val999concat
        System.err.println(map.get(9));
    }
}
