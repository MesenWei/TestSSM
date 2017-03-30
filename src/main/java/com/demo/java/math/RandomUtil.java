package com.demo.java.math;

import java.util.Collection;
import java.util.Random;

/**
 * Created by mesen on 2017/3/29.
 */
public class RandomUtil {
    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numberChar = "0123456789";

    /**
     * 获取[0,max)范围内的一个随机整数
     * @param max
     * @return
     */
    public static Integer genRandomInt(Integer max){
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * 获取[min,max)范围内的一个随机整数
     * @param min
     * @param max
     * @return
     */
    public static Integer genRandomInt(Integer min ,Integer max){
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String genFixS(Integer length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (Integer i = 0; i < length; i++) {
            System.out.println(random.nextInt());
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String genFixLetterS(Integer length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (Integer i = 0; i < length; i++) {
            sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
        }
        return sb.toString();
    }


    /**
     * 返回一个定长的随机纯数字字符串
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String genFixNumberS(Integer length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (Integer i = 0; i < length; i++) {
            sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯大写字母字符串(只包含大小写字母)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String genLowerS(Integer length) {
        return genFixLetterS(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含大小写字母)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String genUpperS(Integer length) {
        return genFixLetterS(length).toUpperCase();
    }

    /**
     * 生成一个定长的纯0字符串
     *
     * @param length
     *            字符串长度
     * @return 纯0字符串
     */
    public static String genZeroS(Integer length) {
        StringBuffer sb = new StringBuffer();
        for (Integer i = 0; i < length; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param num
     *            数字
     * @param fixedLenth
     *            字符串长度
     * @return 定长的字符串
     */
    public static String toFixdLengthS(Long num, Integer fixedLenth) {
        StringBuffer sb = new StringBuffer();
        String strNum = String.valueOf(num);
        if (fixedLenth - strNum.length() >= 0) {
            sb.append(genZeroS(fixedLenth - strNum.length()));
        } else {
            throw new RuntimeException("将数字" + num + "转化为长度为" + fixedLenth
                    + "的字符串发生异常！");
        }
        sb.append(strNum);
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param num
     *            数字
     * @param fixdlenth
     *            字符串长度
     * @return 定长的字符串
     */
    public static String toFixdLengthS(Integer num, Integer fixdlenth) {
        return toFixdLengthS(Long.valueOf(num),fixdlenth);
    }

    /**
     * 从数组中获取随机数据并拼接成字符串。
     * @param objects
     *          数据源
     * @param length
     *          获取数组中数据的个数
     * @return
     */
    public static String genRandomS(Object[] objects, Integer length) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            sb.append(objects[RandomUtil.genRandomInt(objects.length)]);
        }

        return sb.toString();
    }

    /**
     * 从集合中获取随机数据并拼接成字符串。
     * @param col
     *          数据源
     * @param length
     *          获取集合中数据的个数
     * @return
     */
    public static String genRandomS(Collection col , Integer length){
        return genRandomS(col.toArray(),length);
    }

    public static void main(String[] args) {
//        System.out.println(genRandomInt(2,8));
//        System.out.println(genFixS(6));
//        System.out.println(genFixLetterS(6));
//        System.out.println(genLowerS(6));
//        System.out.println(genUpperS(6));
//        System.out.println(genZeroS(6));
        System.out.println(toFixdLengthS(123, 15));
        System.out.println(toFixdLengthS(123L, 15));
    }
}
