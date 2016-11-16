package com.demo.decoratepattern._01proxy;

import java.lang.reflect.Proxy;

/**
 * 普通类，实现了一个接口。
 * 
 * @author weimaosheng
 * 2016年6月22日11:06:53
 */
public class RealSubject implements Subject{

	@Override
	public void doSomething() {
		System.out.println("执行doSomething方法");
	}
	
	@Override
	public void add(){
		System.out.println("执行add方法");
	}
	
	@Override
	public void edit(){
		System.out.println("执行edit方法");
	}
	
	@Override
	public void delete() {
		System.out.println("执行delete方法");
	}

	public static void main(String[] args) {
		Subject rs = ProxyBeanFactory.getInstance();
		
		//静态代理
//		rs.doSomething();
//		rs.delete();
//		rs.add();
//		rs.edit();
		//动态代理
		DynamicProxySubject handler = new DynamicProxySubject(rs);
		Subject proxy = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), rs.getClass().getInterfaces(), handler);
		proxy.add();
	}
}
