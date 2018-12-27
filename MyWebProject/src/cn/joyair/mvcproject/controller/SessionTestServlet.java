package cn.joyair.mvcproject.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.joyair.mvcproject.utils.CaptchaUtils;

@WebServlet("*.sdo")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionTestServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String mn =request.getServletPath();
		mn = mn.substring(1);
		mn = mn.substring(0, mn.length()-4);

		//利用反射，用mn地址名判断方法名
		try {
			Method method = this.getClass().getDeclaredMethod(mn, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void sessionTestServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
		String username = request.getParameter("username");
		String identity = request.getParameter("identity");
		
		HttpSession session = request.getSession();
		
		String sessionUuid = (String)session.getAttribute("uuid");
		session.removeAttribute("uuid");
		
		if(token.equals(sessionUuid)) {
			System.out.println("合法请求，第一次提交表单");
		}else {
			System.out.println("重复提交");
		}
		
		String ucc = (String)request.getParameter("checkCode");  //用户填写的验证码
		String scc = (String)session.getAttribute("cc"); //Session中的验证码
		if(!ucc.equals(scc)) {
			System.out.println("验证码输入有误");
			// return; 终止本次程序提交
		}
	
	}
	
	public void drawCheckCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpg");
		int width=100;
		int height =25;

		CaptchaUtils c = CaptchaUtils.getInstance();
		System.out.println("CaptchaUtils");
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		System.out.println("generateCheckcode");
		req.getSession().setAttribute("cc", checkcode);
		
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
		os.flush();
		os.close();

	}
}
