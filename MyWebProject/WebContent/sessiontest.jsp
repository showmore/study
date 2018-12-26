<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		HttpSession session2 = request.getSession();
		session2.setAttribute("users", "admin");
		out.println("" +session2.getAttribute("users") );
	%>

	
	
	
</body>
</html>