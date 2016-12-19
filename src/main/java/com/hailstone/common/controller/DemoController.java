package com.hailstone.common.controller;

import com.hailstone.common.dao.po.MyStudent;
import com.hailstone.server.business.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 关于方法的返回值，可以使
 * @author  maosheng
 * @date 创建时间：2016年12月19日 下午4:13:32
 */

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoService demoService;

	@RequestMapping("/testMVC")
	public String testMVC(HttpServletRequest request,String id){
		MyStudent ms = demoService.findMyStudentById(id);
		request.setAttribute("ms", ms);
		
		return "demo";
	}
	
}
