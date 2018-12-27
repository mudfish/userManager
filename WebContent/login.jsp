<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<title>登录页面</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" id="account" name="account" /></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" id="password" name="password" /></td> 
			</tr>
			<tr>
				<td align="right"><input type="submit" value="登录" /></td>
				<td align="center"><a href="register.jsp">去注册</a></td>
			</tr>
		</table>
	</form>
	<%
		Object error = request.getAttribute("error");
		if (error != null) {
	%>
	<span style="color: red;"><%=(String) error%></span>
	<%
		}
	%>
</body>
</html>