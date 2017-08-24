package com.ssm.bsms.common.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/** 
 * spring上下文
 * @author  maosheng 
 * @date 创建时间：2016年9月18日 下午10:57:26 
 */
@Component
public class SpringContext implements ApplicationContextAware{
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	
	public ApplicationContext getApplicationContext(){
		return context;
	}
}
