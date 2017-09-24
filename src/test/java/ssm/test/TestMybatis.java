package ssm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.bsms.dao.po.MyStudent;
import com.ssm.server.business.DemoService;

public class TestMybatis {

	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		DemoService demoService = (DemoService)ac.getBean("demoServiceImpl");
		List<MyStudent> myStudent = null;
		try {
			myStudent = demoService.findMyStudent(new MyStudent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(myStudent);
	}
}
