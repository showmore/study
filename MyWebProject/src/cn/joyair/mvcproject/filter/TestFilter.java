package cn.joyair.mvcproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("TestFilter extends HttpFilter");

		chain.doFilter(req, resp); 
		
		
	}
	
	@Override
	protected void init()  {
		
	}
	
	
	
}
