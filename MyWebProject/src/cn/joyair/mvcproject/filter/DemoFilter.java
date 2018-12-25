package cn.joyair.mvcproject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("filter destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("dofilter");
		chain.doFilter(req, resp); //À¹½ØÆ÷ÇëÇóÁ´·ÅÐÐ
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init filter");
		System.out.println(config.getInitParameter("username"));
		
	}
	
}
