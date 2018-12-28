package cn.joyair.mvcproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ÓÃÀ´½ûÖ¹ä¯ÀÀÆ÷»º´æ
 * @author caozhi
 *
 */
public class CleanCache extends HttpFilter  {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse)response;
		System.out.println("CleanCache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Pragma", "no-chache");
		resp.setDateHeader("Expires", -1);
		chain.doFilter(request, resp);
		
	}
}
