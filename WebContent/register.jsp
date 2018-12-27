<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.laoxu.entity.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<title>用户注册</title>
<script type="text/javascript">
	$(function() {
		if ($("#result").length > 0) {
			alert($("#result").text());
		}
	});
</script>
</head>
<body>
	<form action="register" method="post">
		<table>
			<tr>
				<td align="right">登录账号：</td>
				<td><input type="text" id="account" name="account" required="required"/></td>
			</tr>
			<tr>
				<td align="right">真实姓名：</td>
				<td><input type="text" id="username" name="username" required="required" /></td>
			</tr>
			<tr>
				<td align="right">输入密码：</td>
				<td><input type="password" id=password name="password" required="required" /></td> 
			</tr>
			<tr>
				<td align="right">确认密码：</td>
				<td><input type="password" id=cpassword name="cpassword" required="required" /></td> 
			</tr>
			<tr><td></td></tr>
			<tr><td></td></tr>
			<tr>
				<td align="right"><input type="submit" value="注册" /></td>
				<td align="center"><input type="reset" value="重置" /> &nbsp;&nbsp;&nbsp;&nbsp;<a href="login.jsp">去登录</a></td>
			</tr>
		</table>
	</form>
	<%
		Object result = request.getAttribute("registerResult");
			if (result != null) {
	%>
	<span id="result" style="display: none;"><%=(String) result%></span>
	<%
		}
	%>
</body>
</html>