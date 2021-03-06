package cn.joyair.mywebproject;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet implements Servlet {

	public  MyFirstServlet() {
		System.out.println("MyFirstServlet");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
//		String value = config.getInitParameter("user");
		Enumeration<String> enumeration = config.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+":"+value);
		}
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		HttpServletResponse res = (HttpServletResponse) response;
		res.getWriter().write("这是一个Servlet响应");
 	}
	
	

}
