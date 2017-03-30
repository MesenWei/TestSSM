package com.demo.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mesen on 2017/3/29.
 */
public class DateUtil {
    public static final String DATE_TYPE = "yyyy-MM-dd";

    public static final String DATETIME_TYPE = "yyyy-MM-dd HH:mm:ss";

    //===================================
    //日期转换方法
    //===================================

    /**
     * SimpleDateFormat的日期转换。
     * @param date
     * @param dateType
     * @return
     */
    public static String sdfS(Date date, String dateType){
        return new SimpleDateFormat(dateType).format(date);
    }

    /**
     * SimpleDateFormat的日期转换（yyyy-MM-dd HH:mm:ss）。
     * @param date
     * @return
     */
    public static String sdfS(Date date){
        return new SimpleDateFormat(DateUtil.DATETIME_TYPE).format(date);
    }

    /**
     * SimpleDateFormat的日期转换（yyyy-MM-dd HH:mm:ss）。
     * @param date
     * @return
     */
    public static String sdfS(String date) throws ParseException {
        return sdfS(sdfD(date), DateUtil.DATETIME_TYPE);
    }

    /**
     * SimpleDateFormat的日期转换。
     * @param date 格式必须是yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date sdfD(String date) throws ParseException {
        return new SimpleDateFormat(DateUtil.DATETIME_TYPE).parse(date);
    }

    /**
     * SimpleDateFormat的日期转换。
     * dateType 的格式类型，必须和date的格式类型一致：
     * 2017-3-29 18:58:41 yyyy-MM-dd HH:mm:ss可以转换成功
     * 2017-3-29 18:58:41 yyyy-MM-dd HH-mm-ss转换会出现异常
     * @param date
     * @return
     */
    public static Date sdfD(String date,String dateType) throws ParseException {
        return new SimpleDateFormat(dateType).parse(date);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date dateD(){
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取时间
     * @return
     */
    public static Date dateD(Calendar calendar){
        return calendar.getTime();
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String dateS(){
        return sdfS(Calendar.getInstance().getTime());
    }

    /**
     * 获取时间
     * @return
     */
    public static String dateS(Calendar calendar){
        return sdfS(calendar.getTime());
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String dateS(String dateType){
        return sdfS(Calendar.getInstance().getTime(),dateType);
    }

    /**
     * 获取时间
     * @return
     */
    public static String dateS(Calendar calendar,String dateType){
        return sdfS(calendar.getTime(),dateType);
    }

    //===================================
    //Calendar计算
    //===================================

    /**
     * 获取年份
     * @return
     */
    public static int genYear(){
        return Calendar.YEAR;
    }

    /**
     * 获取月份
     * @return
     */
    public static int genMonth(){
        Calendar calendar = Calendar.getInstance();

        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当月几日
     * @return
     */
    public static int genDay(){
        Calendar calendar = Calendar.getInstance();

        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取某月最后一天
     * @return
     */
    public static Calendar genMonthLastDay(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);// 设为当前月的1号

        calendar.add(Calendar.MONTH, month-2);
        calendar.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

        return calendar;
    }

    /**
     * 计算当月最后一天。
     * @return
     * @throws ParseException
     */
    public static Date genMonthLastDayD(boolean appendHMS) throws ParseException {
        if(appendHMS)
            return sdfD(genMonthLastDayS(appendHMS), DateUtil.DATETIME_TYPE);
        else
            return sdfD(genMonthLastDayS(appendHMS),DateUtil.DATE_TYPE);
    }

    /**
     * 计算当月最后一天。
     * @return
     * @throws ParseException
     */
    public static String genMonthLastDayS(boolean appendHMS){
        if(appendHMS)
            return sdfS(genMonthLastDay(1).getTime(),DateUtil.DATE_TYPE) + " 23:59:59";
        else
            return sdfS(genMonthLastDay(1).getTime(),DateUtil.DATE_TYPE);
    }

    /**
     * 计算某月最后一天。
     * @return
     * @throws ParseException
     */
    public static Date genMonthLastDayD(Integer month,boolean appendHMS) throws ParseException {
        if(appendHMS)
            return sdfD(genMonthLastDayS(month,appendHMS), DateUtil.DATETIME_TYPE);
        else
            return sdfD(genMonthLastDayS(month,appendHMS),DateUtil.DATE_TYPE);
    }

    /**
     * 计算某月最后一天。
     * @return
     * @throws ParseException
     */
    public static String genMonthLastDayS(Integer month,boolean appendHMS){
        if(appendHMS)
            return sdfS(genMonthLastDay(month).getTime(),DateUtil.DATE_TYPE) + " 23:59:59";
        else
            return sdfS(genMonthLastDay(month).getTime(),DateUtil.DATE_TYPE);
    }

    /**
     * 获取前一个月
     *
     * @return
     */
    public static Calendar genPreviousMonthFirstDayC() {
        Calendar calendar = Calendar.getInstance();

        // 设为当前月的1号
        calendar.set(Calendar.DATE, 1);

        // 上一个月
        calendar.add(Calendar.MONTH, -1);

        return calendar;
    }

    /**
     * 获取指定月份前一个月的第一天。
     * @return
     * @throws ParseException
     */
    public static Date genPreviousMonthFirstDayD(boolean appendHMS) throws ParseException {
        if(appendHMS)
            return sdfD(genPreviousMonthFirstDayS(appendHMS));
        else
            return sdfD(genPreviousMonthFirstDayS(appendHMS),DateUtil.DATE_TYPE);
    }

    /**
     * 获取指定月份前一个月的第一天。
     * @return
     */
    public static String genPreviousMonthFirstDayS(boolean appendHMS) {
        if(appendHMS)
            return sdfS(genPreviousMonthFirstDayC().getTime(), DateUtil.DATE_TYPE) + " 00:00:00";
        else
            return sdfS(genPreviousMonthFirstDayC().getTime(), DateUtil.DATE_TYPE);
    }

    /**
     * 获取本周第一天
     * @return
     */
    public static Calendar genDayOfWeekC() {
        Calendar calendar= Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return calendar;

    }

    /**
     * 获取本周第一天
     * @param appendHMS
     * @return
     */
    public static String genDayOfWeekS(boolean appendHMS){
        if (appendHMS)
            return sdfS(genDayOfWeekC().getTime(), DateUtil.DATE_TYPE) + " 00:00:00";
        else
            return sdfS(genDayOfWeekC().getTime(), DateUtil.DATE_TYPE);
    }

    /**
     * 获取本周第一天
     * @param appendHMS
     * @return
     * @throws ParseException
     */
    public static Date genDayOfWeekD(boolean appendHMS) throws ParseException {
        if (appendHMS)
            return sdfD(sdfS(genDayOfWeekC().getTime(),DateUtil.DATE_TYPE) + " 00:00:00",DateUtil.DATE_TYPE);
        else
            return genDayOfWeekC().getTime();
    }

    /**
     * 获取前几天
     * @param day
     * @return
     */
    public static Calendar genPreviousDayC(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0 - day);

        return calendar;
    }

    /**
     * 获取前几天
     * @param day
     * @return
     */
    public static String genPreviousDayS(int day) {
        return sdfS(genPreviousDayC(day).getTime(),DateUtil.DATE_TYPE);
    }

    /**
     * 获取前几天
     * @param day
     * @return
     */
    public static Date genPreviousDayD(int day) throws ParseException {
        return sdfD(genPreviousDayS(day),DateUtil.DATE_TYPE);
    }

    public static void main(String[] args) throws ParseException {
//        System.out.println(genMonthLastDayS(true));
//        System.out.println(genMonthLastDayD(true));
//        System.out.println(genMonthLastDayS(0,false));
//        System.out.println(genMonthLastDayD(2,true));
//        System.out.println(genPreviousMonthFirstDayD(true));
//        System.out.println(genPreviousMonthFirstDayS(false));
//        System.out.println(genDayOfWeekD(true));
//        System.out.println(genDayOfWeekS(true));
//        System.out.println(genPreviousDayS(2));
//        System.out.println(genPreviousDayD(3));
        System.out.println(dateS("yyyy/MM/dd HH/mm/ss"));

    }
}
