package cn.joyair.mvcproject.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.rmi.server.ServerCloneException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joyair.mvcproject.model.User;
import cn.joyair.mvcproject.service.FactoryService;
import cn.joyair.mvcproject.service.UserService;

public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	UserService userService = FactoryService.getUserService(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		System.out.println("������doPOST����");
		// ����һ����������Ҫת����ɾ�Ĳ�����
		
		// �����ַ���
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String mn =req.getServletPath();
		mn = mn.substring(1);
		mn = mn.substring(0, mn.length()-4);

//		if(mn.equals("query")) {
//			query();
//		}
		//���÷��䣬��mn��ַ���жϷ�����
		try {
			Method method = this.getClass().getDeclaredMethod(mn, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		User user = new User();
		user.setName(req.getParameter("username"));
		user.setId(req.getParameter("userID"));
		user.setIdentity(req.getParameter("identity"));
		user.setPhone(req.getParameter("phone"));
		
		int rows = userService.save(user);
		if(rows>0) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
//			throw new RuntimeException("�����û�ʧ�ܣ�");
		}
	}
	
	private void query(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		System.out.println("Let's query!");
		String username = req.getParameter("username");
		String identity = req.getParameter("identity");
		String phone = req.getParameter("phone");
		
		/**�������ʽ**/
	    String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
	                + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
		
	    username = username.replaceAll(reg, "");
	    identity = identity.replaceAll(reg, "");
	    phone = phone.replaceAll(reg, "");
	    
		List<User> list = userService.query(username,identity,phone);
		System.out.println(list);
		req.setAttribute("userList", list); // �ѽ�����ŵ�req�����Կռ�
		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		String id = req.getParameter("userID"); 
		
		int rows = userService.deleteUserById(id);
		if(rows>0) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		String id = req.getParameter("userID");
		User user = userService.get(id);
		req.setAttribute("user", user);
		System.out.println(user);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
		
	}
	
	private void updatedo(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		String id = req.getParameter("userID");
		// ͨ��id,�����ݿ���ԭ����User��Ϣ�õ�
		User user = userService.get(id);
		
		String yUsername = user.getName();
		String xUsername = req.getParameter("username");
		
		long cout = userService.getCountByName(xUsername);
		
		if(!xUsername.equals(yUsername) && cout > 0) {
			// ���������ֲ�һ��������£������������ݿ����ҵ�ͬ����¼��֤�������ֳ�ͻ
			req.setAttribute("note", xUsername+",��������Ѿ���ռ�ã��뻻һ�����֣�");
			req.getRequestDispatcher("/update.udo?id="+id).forward(req, resp);
			return;
		}
		
		user.setName(xUsername);
		user.setIdentity(req.getParameter("identity"));
		user.setPhone(req.getParameter("phone"));
		
		int rows = userService.updateUserById(user);
		if(rows>0) {
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/error.jsp");
		}
		
		
		
		
		
	}
	
	
}