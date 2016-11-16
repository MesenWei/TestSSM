package com.demo.java.thread;
/** 
 * 
 * @author  maosheng 
 * @date 创建时间：2016年10月24日 下午7:11:43
 */
public class MySyn {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Timer timer = new Timer();
		mr.setTimer(timer);
		
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		t2.start();
	}
}	

class MyRunnable implements Runnable{
	private Timer timer;
	@Override
	public void run() {
		if(null != timer){
			timer.add(Thread.currentThread().getName());
		}
	}
	
	public void setTimer(Timer timer){
		this.timer = timer;
	}
	
}

class Timer{
	private static int num = 0;
	public synchronized void add(String name){
		num ++;
		try{
			/**
			 * 因为睡眠了这1毫秒，所以可能有另一线程进入到此方法，执行输出语句，但是num得数据不准确了，
			 * 所以加上线程锁
			 */
			Thread.sleep(1);
		}catch(InterruptedException e){
		}
		System.out.println(name+"你是第"+num+"个使用Timer的线程");
	}
}

