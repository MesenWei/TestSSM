package com.demo.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4100655090563700631L;
	
	
	public HelloServlet() {
		System.out.println("����Servletʵ��");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("��ʼ��ʵ��");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("����ʵ��");
	}
	
	public void print(HttpServletRequest req, HttpServletResponse resp){
		System.out.println (req.getMethod ());
		System.out.println (req.getProtocol ());
		System.out.println (req.getRequestURI ());
		System.out.println (req.getRequestURL ());
		System.out.println (req.getServletPath ());
	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//		a(req,resp);
//		b(req,resp);
		c(req,resp);
		
		
	}
	
	public void a(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write("<h1>Hello Servlet.");
		out.close();
	}
	
	public void b(HttpServletRequest req, HttpServletResponse resp){
		PersonEntity pe = new PersonEntity();
		pe.setName("wms");
		pe.setAge(26);
		pe.setSex("男 ");
		pe.setTelephoneNo("13693100586");
		
		req.setAttribute("pe", pe);
		try {
			
			req.getRequestDispatcher("WEB-INF/template/b.jsp").forward(req, resp);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		};
	}
	
	public void c(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession(true);
		System.out.println(session);
	}
	
}
