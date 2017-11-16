package com.demo.jms.pressure;

import javax.jms.TextMessage;

/**
 * Created by mesen on 2017/9/25.
 */
public class HandleMsg {
    private static int count = 0;
    public static void test(TextMessage textMessage){
        try {
            count ++ ;
            System.out.println("开始处理第" + count + "条数据。");
            Thread.sleep(500);
            if(count == 10)
                throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
