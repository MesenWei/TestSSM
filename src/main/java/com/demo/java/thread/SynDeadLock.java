package com.demo.java.thread;
/** 
 * 线程死锁
 * @author  maosheng 
 * @date 创建时间：2016年10月24日 下午10:42:08
 */
public class SynDeadLock {
	public static void main(String[] args) {
		TestDeadLock dl1 = new TestDeadLock();
		TestDeadLock dl2 = new TestDeadLock();
		dl1.flag = 1;
		dl2.flag = 0;
		
		Thread t1 = new Thread(dl1);
		Thread t2 = new Thread(dl2);
		t1.start();
		t2.start();
	}
}
class TestDeadLock implements Runnable{
	public int flag = 1;
	static Object o1 = new Object();
	static Object o2 = new Object();
	
	@Override
	public void run() {
		System.out.println("flag="+flag);
		
		if(flag == 1){
			synchronized(o1){
				try {
					System.out.println("A区o1锁上了");
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				synchronized(o2){
					System.out.println("A区o2锁上了");
					System.out.println("flag 1 is ok!");
				}
			}
		}
		
		if(flag == 0){
			synchronized(o2){
				try {
					System.out.println("B区o2锁上了");
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				synchronized(o1){
					System.out.println("B区o1锁上了");
					System.out.println("flag 2 is ok!");
				}
			}
		}
		
	}
	
}