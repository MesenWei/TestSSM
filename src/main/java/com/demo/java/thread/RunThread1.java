package com.demo.java.thread;
/** 
 * 
 * @author  maosheng 
 * @date 创建时间：2016年10月24日 下午9:46:32
 */
public class RunThread1 {
	public static void main(String[] args) {
		MyRunable mr = new MyRunable();
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		t1.start();
		t2.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mr.shutDown();
	}
}
class MyRunable implements Runnable{
	boolean flag = true;
	
	@Override
	public void run() {
		while (flag){
			for(int i=0,l=10;i<l;i++){
				System.out.println("当前取值为："+i);
			}
		}
	}
	
	public void shutDown(){
		flag = false;
	}
	
}