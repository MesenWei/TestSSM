package com.demo.java.thread;
/** 
 * 线程启动方式2
 * @author  maosheng 
 * @date 创建时间：2016年10月24日 下午9:46:32
 */
public class RunThread2 {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mt.shutDown();
	}
}

class MyThread extends Thread{
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