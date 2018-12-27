<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productdetails</title>
</head>
<body>
	<%
		String pname = (String)request.getAttribute("p");
		out.println(pname);
	%>
	<br><br>
	<span>一些<%=pname %>的描述信息。。。。</span>
	<br><br>
	<form action="">
		<input type="hidden" name="pname" value="<%=pname %>">
		<input style="width:120px; height:30px; background:red;color:#fff;"
			 type="submit" value="加入购物车">
	</form>
	
	<br><br><br>
	
	<a style="display:block;width:150px;height:40px;background:red;color:#fff;
	line-height:40px;text-align:center;text-decoration:none;"
		 href="<%=request.getContextPath()%>/addcart.pdo?pname=<%=pname %>">加入购物车</a>
	
	
	
</body>
</html>