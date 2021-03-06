<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="cn.joyair.mvcproject.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Test Index</title>
<style>
tr {
	height: 40px;
}

td {
	padding: 10px;
	width: 180px;
	text-align: center;
}
</style>
</head>
<body>
	<%-- 
	<%
		String username = (String)request.getSession().getAttribute("user");
		if(username==null || "".equals(username)){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	%>
--%>


	<form action="<%=request.getContextPath()%>/query.udo">
		<table
			style="margin: 0 50px; padding: 50px; border: 1px #ccc solid; width: 400px;">
			<tr>
				<td style="text-align: right;">用户名：</td>
				<td style="text-align: left;"><input type="text"
					name="username" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">身份证号：</td>
				<td style="text-align: left;"><input type="text"
					name="identity" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">电话：</td>
				<td style="text-align: left;"><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center;"><input type="submit"
					value="查询用户" />
			</tr>
			<tr>
				<td colspan=2 style="text-align: center;"><a
					href="<%=request.getContextPath()%>/add.jsp">添加新用户</a></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center;"><a
					href="<%=request.getContextPath()%>/logout.udo">退出登陆</a></td>
			</tr>

		</table>
	</form>



	<table style="margin-left: 50px; padding: 10px;" border="1"
		cellpadding="0" cellspacing="0">
		<tr>
			<td>用户ID</td>
			<td>用户名称</td>
			<td>身份证号</td>
			<td>生日</td>
			<td>电话</td>
			<td></td>
		</tr>
		<%
			List<User> list = (List<User>) request.getAttribute("userList");
			if (list != null && list.size() > 0) {
				for (User user : list) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getIdentity()%></td>
			<td><%=user.getBirthday()%></td>
			<td><%=user.getPhone()%></td>
			<td><a
				href="<%=request.getContextPath()%>/update.udo?userID=<%=user.getId()%>">编辑</a>
				<a
				href="<%=request.getContextPath()%>/delete.udo?userID=<%=user.getId()%>">删除</a>
			</td>
		</tr>
		<%
			}
			}
		%>
		<tr>

		</tr>
	</table>
	
	<br><br>
	


	

	<table border="1" cellpadding="0" cellspacing="0" style="width:80%;margin:0 auto;">
		
		<tr>
			<td>在线用户ID</td>
			<td>在线用户名</td>
		</tr>

		<%
			Map<String,String> online = (Map<String,String>)application.getAttribute("online");
			if(online!=null){
				
				for(String str:online.keySet()){
				
		
		%>
				<tr>
					<td><%=str %></td>
					<td><%=online.get(str) %></td>
				</tr>
		<%
				}
			}
		%>

	</table>
	


</body>
</html>