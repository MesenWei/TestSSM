package com.demo.java.thread.video.com.itlaoqi.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 模拟购票系统。
 * <p>
 * Created by maosheng on 2018/8/8.
 */
public class BuyTicket {

    public static void main (String[] org0){
        people();
    }

    public static void people(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(50);//500张票

        /** 模拟100个人抢50张票。
         *  避免后进来的线程，因为CPU优先分配线程而先买到票的可能。
         */
        Long start = System.currentTimeMillis();
        for(int i=0;i<100;i++){
            if(semaphore.tryAcquire()){
                try {
                    semaphore.acquire();
                    executorService.submit(new Buy());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("sorry,票已经卖完了！");
            }
        }

        /**
         * 总共应该大约在1秒钟才对。
         */
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}

class Buy implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("购票成功！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
