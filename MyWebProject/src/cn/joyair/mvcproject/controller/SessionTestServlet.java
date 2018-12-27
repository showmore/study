package cn.joyair.mvcproject.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTestServlet")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SessionTestServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("请求来了一次！");
		
		
		
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
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
