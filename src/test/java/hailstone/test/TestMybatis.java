package hailstone.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hailstone.common.dao.po.MyStudent;
import com.hailstone.server.business.DemoService;

public class TestMybatis {

	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		DemoService demoService = (DemoService)ac.getBean("demoServiceImpl");
		List<MyStudent> myStudent = demoService.findMyStudent(new MyStudent());
		System.out.println(myStudent);
	}
}
