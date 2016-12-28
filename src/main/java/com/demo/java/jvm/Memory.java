package com.demo.java.jvm;

/**
 * class文件常量池
 *      常量和字面量和符号引用
 *
 * 类变量
 *      静态常量和静态变量
 *
 * 运行时常量池
 *      class文件常量池和类变量
 *
 * Created by mesen on 2016/12/26.
 */
public class Memory {
    /**
     * 成员变量
     * 基本类型a存储在堆中的Memory对象里；4存储在堆中的Memory的class文件常量池中。
     * 基本类型a指向Memory的class文件常量池中4的地址。
     */
    private int a = 4;

    /**
     * 成员变量
     * 基本类型a存储在堆中的Memory对象里；b指向的是堆中的Memory的class文件常量池中的4的地址，
     * 在创建a的时候已经已经创建了4，所以创建b的时候不会再次创建了。
     */
    private int b = 4;

    /**
     * 成员变量
     * 引用str1存储在堆中的Memory对象里;abc存储在堆中的Memory的class文件常量池中。
     * 引用str1指向abc在class文件常量池中的地址。
     */
    private String str1 = "abc";

    /**
     * 成员变量
     * 说明：通过构造方法来创建对象实际上是操作了两步，
     *          一是创建字面量def存到class文件常量池中(如果def不存在)；
     *          二是创建对象String的实例。
     * 引用str2存储在堆中的Memory对象里；
     * 字符串def在class文件常量池中不存在，所以在class文件常量池中创建对象def；
     * 创建String实例。
     * 引用str2指向String实例。
     *
     */
    private String str2 = new String("def");

    /**
     * 成员变量
     * 引用str3存储在堆中的Memory对象里；
     * 字符串def在class文件常量池中已经存在，所以不会被创建；
     * 创建String实例。
     * 引用str3指向String实例。
     *
     * 网上有说在常量池中创建了字符串def对象后，将其复制给了String对象，表示对这句话没看懂！
     */
    private String str3 = new String("def");

    /**
     * 静态变量
     * 基本数据类型c存储在方法区的运行时常量池中，起初c指向的是一个符号链接，
     * 当对象真正被使用时，c指向的是直接连接，也就是指向了4。
     * 4存储在堆中的class文件常量池中。
     */
    public static int c = 4;

    /**
     * 静态变量
     * 引用str4存储在方法区的运行时常量池中；
     * 因为abc在堆中的Memory的class文件常量池中已经存在了，所以不会被再次创建。所以str4指向的是堆中的abc，
     * 当然也是由符号链接到直接连接。
     */
    public static String str4 = "abc";

    /**
     * 静态变量
     * 引用str5存储在方法区的运行时常量池中；
     * 因为abc在堆中Memory的class文件常量池中已经存在了，所以不会被再次创建。
     * String实例在堆中创建，str5指向String实例。
     * 当然也是由符号链接到直接连接。
     */
    public static String str5 = new String("abc");

    /**
     * 常量
     * todo 引用和实例都存在运行时常量池中？
     *
     */
    public final String str6 = "abc";

    /**
     * 静态常量
     * todo 引用和实例都存在运行时常量池中？
     */
    public static final String str7 = "abc";

    public void memoryTest(){
        //局部变量(临时变量)

        /**
         * 局部变量
         * 基本数据类型e存储在栈中，字面量4也存储在栈中。
         */
        int e = 4;

        /**
         * 局部变量
         * 基本数据类型f存储在栈中，f指向e。
         */
        int f = 4;

        /**
         * 局部变量
         * 引用str8存在栈中，指向堆中Memory的class文件常量池中的abc
         */
        String str8 = "abc";

        /**
         * 局部变量
         * 引用str9存在栈中。
         * String实例在堆中创建，str9指向该实例。
         * def指向堆中Memory的class文件常量池中的def。
         */
        String str9 = new String("def");

    }

    public static void main(String[] arg0){
        Memory memory = new Memory();
        memory.memoryTest();
    }

}