package com.demo.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4100655090563700631L;
	
	
	public HelloServlet() {
		System.out.println("自定义的servlet启动了");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("HelloServlet is initing...");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("HelloServlet is destroying...");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//		a(req,resp);
//		b(req,resp);
		c(req,resp);
//		d(req,resp);

		
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
		}
	}

	/**
	 * 1.如果req.getSession(true)不被执行，则没有session创建
	 * 	 cookie中是没有jsessionid
	 * 2.如果req.getSession(true)被执行了，则session被创建
	 *   cookie中有了jsessionid，当请求再次访问的时候，请求中带有jsessionid
	 *   同时也证明，jsessionid是自动写入cookie的。
	 * 3.如果浏览器禁用了cookie，后端逻辑没有变化，只是写入cookie的jsessionid
	 *   不能保存在浏览器中，所以在发起请求的时候，tomcat无法获取jsessionid。
	 * @param req
	 * @param resp
	 */
	public void c(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession(true);
		System.out.println(session);
	}

	public void d(HttpServletRequest req, HttpServletResponse resp){
		Cookie[] cookies = req.getCookies();
//		for(Cookie c : cookies){
//			String value = c.getValue();
//			System.out.println(c);
//		}
	}

	public void e(HttpServletRequest req, HttpServletResponse resp){
		System.out.println (req.getMethod ());
		System.out.println (req.getProtocol ());
		System.out.println (req.getRequestURI ());
		System.out.println (req.getRequestURL ());
		System.out.println (req.getServletPath ());
	}
	
}
