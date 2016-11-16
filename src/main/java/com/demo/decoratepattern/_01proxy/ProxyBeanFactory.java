package com.demo.decoratepattern._01proxy;

public class ProxyBeanFactory {
	public static Subject getInstance(){
		Subject subject = new StaticProxySubject(new RealSubject());
		return subject;
	}
}
