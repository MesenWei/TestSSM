package com.demo.decoratepattern._01proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类：本来由别的类实现的功能，现在有此类来代理。
 * @author weimaosheng
 * 2016年6月22日11:08:00
 */
public class ProxySubject {

}

/**
 * 静态代理类。
 * @author weimaosheng
 * 2016年6月22日上午11:09:09
 */
class StaticProxySubject implements Subject{
	private Subject rs ;
	
	public StaticProxySubject(RealSubject rs) {
		this.rs = rs;
	}
	
	@Override
	public void doSomething() {
		System.out.println("doSomething-----started");
		rs.doSomething();
		System.out.println("doSomething-----ended");
	}

	@Override
	public void add() {
		System.out.println("add-----started");
		rs.add();
		System.out.println("add-----ended");
	}

	@Override
	public void edit() {
		System.out.println("edit-----started");
		rs.edit();
		System.out.println("edit-----ended");
	}

	@Override
	public void delete() {
		System.out.println("delete");
		rs.delete();
		System.out.println("delete");
	}
	
}

/**
 * 动态代理
 * @author weimaosheng
 * 2016年6月22日上午11:10:28
 */
class DynamicProxySubject implements InvocationHandler{
	Object object ;
	public DynamicProxySubject(Object object){
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法开始执行");
		method.invoke(object,args);
		System.out.println("方法执行结束");
		return null;
	}
	
}
