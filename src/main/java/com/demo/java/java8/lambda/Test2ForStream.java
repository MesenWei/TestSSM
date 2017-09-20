package com.demo.java.java8.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream基本用法
 *
 * 当把一个数据结构包装成Stream后，就要开始对里面的元素进行各类操作了。常见的操作可以归类如下。
 *
 * Intermediate：中间操作
 * map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
 *
 * Terminal： 最终操作
 * forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
 *
 * Short-circuiting： 短路操作
 * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 *
 * Created by maosheng on 2017/9/12.
 */
public class Test2ForStream {
    static List<String> features = Arrays.asList("Lambdas", "Default Method","Default Method", "Stream API", "Date and Time API");

    /**
     * 集合和stream都有forEach方法，作用是遍历。
     */
    public static void forEach(){
        features.forEach(n -> System.out.println(n));
    }

    /**
     * stream-filter：过滤
     */
    public static void filter(){
        features.parallelStream().filter(s -> s.contains("D")).forEach(s -> System.out.println(s));
    }

    /**
     * stream-distinct：去重
     */
    public static void distinct(){
        features.parallelStream().distinct().forEach(s -> System.out.println(s));
    }

    /**
     * stream-count：计数
     */
    public static void count(){
        long count = features.parallelStream().filter(s -> s.contains("a")).count();
        System.out.println(count);
    }

    /**
     * stream-collect：生成新的集合
     */
    public static void collect(){
        List<String> collect = features.parallelStream().filter(s -> s.contains("a")).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * stream-peek：对stream中的数据进行操作后返回一个新的stream，
     *              新的stream中的元素与原stream中的元素没有任何改变。
     */
    public static void peek(){
        List<String> list = Arrays.asList("one", "two", "three", "four");

        List<String> list2 = list.stream()
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("第一次符合条件的值为: " + e))
                .filter(e->e.length()>4)
                .peek(e -> System.out.println("第二次符合条件的值为: " + e))
                .collect(Collectors.toList());

        System.out.println(list2.size());

        //测试peek返回的stream是不是新的对象：是新的stream对象。
        Stream<String> stream = list.stream();
        System.out.println(stream);
        Stream<String> stream1 = stream.filter(e -> e.length() > 3)
                .peek(e -> System.out.println("第一次符合条件的值为: " + e));
        System.out.println(stream1);
    }

    /**
     * stream-map：将每一个参数重新处理后，将所有处理后的数据存入（映射）一个新的stream并返回。
     * stream-flatMap：将每一个参数处理后得到对应新的stream，把所有新的stream相加得到另一个新的stream并返回。
     */
    public static void map(){
        List<String> collect1 = features.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect1);

        Stream<String> stream1 = Stream.of("tom.Li","lucy.Liu");

        Stream<String> stream2 = stream1.map(s -> s + ".china");
        stream2.forEach(System.out::println);

    }

    /**
     * stream-map：将每一个参数重新处理后，将所有处理后的数据存入（映射）一个新的stream并返回。
     * stream-flatMap：将每一个参数处理后得到对应新的stream，把所有新的stream相加得到另一个新的stream并返回。
     */
    public static void flatMap(){
        Stream<String> stream1 = Stream.of("tom.Li","lucy.Liu");

        Stream<String> stream3 = stream1.flatMap(s->Stream.of(s.split("[.]")));
        stream3.forEach(System.out::println);
    }

    /**
     * stream-reduce：将stream中的每一个元素依照运算规则（BinaryOperator）进行处理。
     *                BinaryOperator和比较类似，都是讲相邻元素做同样的操作。
     */
    public static void reduce(){
        List<String> list = Arrays.asList("test","javap","hello","world","java","tom","C","javascript");
        Optional<String> reduce    =  list.stream()
                .sorted((s1,s2)->s2.length()-s1.length())
                .filter(s->s.startsWith("j"))
                .map(s->s+"_briup")
                .reduce((s1,s2)->s1+"|"+s2);
        reduce.ifPresent(System.out::print);
    }

    /**
     * Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
     */
    public static void stream(){
        //生成100万个不同的字符串放到集合中
        int max = 10000000;
        List<String> values = new ArrayList(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }


        long t0 = System.currentTimeMillis();

        //串行stream
        long count = values.stream().sorted().count();

        //并行stream
        //long count = values.parallelStream().sorted().count();

        long t1 = System.currentTimeMillis();

        long time = t1 - t0;

        System.out.println(count);
        System.out.println(time);
    }

    public static void puttingItTogether(){
        List<String> people = Arrays.asList("awe","ab","weaq","asdfgasg","e");
        Collections.sort(people, new Comparator<String>() {
            public int compare(String x, String y) {
                return y.length() - x.length();
            }
        });
        people.forEach(System.out::println);

        people = Arrays.asList("awe","ab","weaq","asdfgasg","e");
        Collections.sort(people,(x,y) -> x.length() - y.length());
        people.forEach(System.out::println);

        people = Arrays.asList("awe","ab","weaq","asdfgasg","e");
        Collections.sort(people, Comparator.comparing(str -> str.length()));
        people.forEach(System.out::println);

        //people.sort();
    }

    public static void main (String[] org0){
        //forEach();
        //filter();
        //distinct();
        //count();
        //collect();
        //peek();
        //map();
        //flatMap();
        //reduce();
        //stream();
        puttingItTogether();
    }

}

@FunctionalInterface
interface Apple{
    String run(Integer i);
}

@FunctionalInterface
interface Action<T>{
    void run(T t);
}

@FunctionalInterface
interface Action2{
    //void run(String name);
    //void run();
    Model run();
}

class Model{
    public Model(){
        System.out.println("aaaaaaaaaaa");
    }

    public Model(String name){
        System.out.println(name);
    }

    public void test1(){
        System.out.println("test1");
    }

    public void test2(Model a){
        System.out.println("test2");
    }

    public int test3(){
        System.out.println("test3");
        return 1;
    }

    public int test4(Integer integer){
        System.out.println("test3");
        return 1;
    }

    public static boolean test5(String name){
        System.out.println(name);
        return name.contains("a");
    }
}

class Person {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void main (String[] org0){
        Person[] people = {};
        Function f = (p) -> {return null;};
        Comparator<Person> byName = Comparator.comparing(f);
        Arrays.sort(people, byName);
    }
}
