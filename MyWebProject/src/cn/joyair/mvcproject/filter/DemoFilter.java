package cn.joyair.mvcproject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DemoFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("filter destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("dofilter");
		HttpServletRequest hreq = (HttpServletRequest)req;
		chain.doFilter(req, resp); //����������������
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		System.out.println("init filter");
		System.out.println("�õ��˳�ʼ��������"+config.getInitParameter("username"));
		
	}
	
}
