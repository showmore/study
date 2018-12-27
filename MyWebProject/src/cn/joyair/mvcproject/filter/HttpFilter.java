package cn.joyair.mvcproject.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DocumentFilter;

public class HttpFilter implements Filter {
	private FilterConfig filterConfig;
	public FilterConfig getFilterConfig() {
		return this.filterConfig;
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		doFilter((HttpServletRequest) req, (HttpServletResponse) resp, chain  );
	}
	
	/**
	 * 提供给子类覆盖的方法
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
	}
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig =  config;
		init();
	}

	/**
	 * 提供给子类覆盖
	 */
	protected void init() {
		
	}
}
