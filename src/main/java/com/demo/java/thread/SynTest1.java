package com.demo.java.thread;
/** 
 * 
 * @author  maosheng 
 * @date 创建时间：2016年10月24日 下午11:27:34
 */
public class SynTest1 {
	public static void main(String[] args) {
		Test1 test = new Test1();
		new Thread(test).start();
		try {
			/**
			 * 此时有一个线程访问m1，有一个线程访问m2，
			 * 因为m1和m2都被锁住，其根本是对Test1的锁住，
			 * 所以在m1被锁期间，即使m2的方法已经执行，并改变了b的值，但是仍然无法改变m1中b的值。
			 */
			test.m2();
			System.out.println(test.b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Test1 implements Runnable{
	int b = 100;
	public synchronized void m1 () throws InterruptedException{
		b = 1000;
		System.out.println("m1开始");
		Thread.sleep(5000);
		System.out.println("m1:"+b);
	}
	
	public synchronized void m2() throws InterruptedException{
		System.out.println("m2开始");
		Thread.sleep(2500);
		b = 2000;
		System.out.println("m2:"+b);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}