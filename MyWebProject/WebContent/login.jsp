<%@ page language="java" session="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<%--
	<%
		
		Cookie[] cookieArr = request.getCookies();
		if(cookieArr!=null && cookieArr.length >0){
			for(int i=0;i<cookieArr.length;i++){
				out.println("cookie名称："+cookieArr[i].getName()+"<br/>"+"   cookie的值： "+cookieArr[i].getValue()+"<br/>");
			}
		}
		else{
			Cookie cookie = new Cookie("uuid", "uuidvalue");
			cookie.setMaxAge(1*24*60*60);
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setPath("/");
			
			response.addCookie(cookie);
		}
	
--%>

	<form action="<%=request.getContextPath()%>/login.udo">
		<table style="margin:280px auto; padding: 50px; border: 1px #ccc solid; width: 400px;">
			<tr>
				<td style="text-align: right;">用户名：</td>
				<td style="text-align: left;"><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">密码：</td>
				<td style="text-align: left;"><input type="text" name="identity" /></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center;">
					<input type="radio" name="expiredays" value="7" />记住一周  <br>
				    <input type="radio" name="expiredays" value="30" />记住一月 <br>
					<input type="radio" name="expiredays" value="100" />永远记住  <br>
				</td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center; padding-top:10px;"><input type="submit" value="登陆" /></td>
			</tr>

		</table>
	</form>
	
	
</body>


<script type="text/javascript">
	function setCookie(c_name, c_value, c_expiredays){ //expiredays单位是天
		var expires = "";
		if(c_expiredays!=null){
			var sysDate = new Date();
			//alert(sysDate.toUTCString());
			sysDate.setDate(sysDate.getDate()+c_expiredays);
			//alert(sysDate.toUTCString());
			expires = ";expires" + sysDate.toUTCString();
		}
		document.cookie= c_name +"="+escape(c_value)+expires;
	}
	
	function getCookie(c_name){
		if(document.cookie.length>0){
			var start = document.cookie.indexOf(c_name+"=");
			start = start + c_name.length + 1;
			var end = document.cookie.indexOf(";", start);
			if(end==-1) end = document.cookie.length;
			var val = document.cookie.substring(start,end);
			return unescape(val);
		}
	};
	
	function deleteCookie(c_name){
		var sysDate = new Date();
		sysDate.setDate(sysDate.getDate()-1);
		var time = ";expires="+sysDate.toUTCString();
		var val = getCooke(c_name);
		document.cookie = c_name +"="+escape(val)+expires;
		
	}
	
	//setCookie("ssid","abc",1);
	//alert(document.cookie);
	//alert(getCookie("ssid"));
	
</script>


</html>