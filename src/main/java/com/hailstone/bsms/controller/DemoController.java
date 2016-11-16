package com.hailstone.bsms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hailstone.common.dao.po.MyStudent;
import com.hailstone.server.business.DemoService;

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
