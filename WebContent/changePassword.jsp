<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.laoxu.entity.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	User user = ((User) session.getAttribute("user"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<title>修改密码</title>
<script type="text/javascript">
	$(function() {
		if ($("#result").length > 0) {
			alert($("#result").text());
		}
	});
</script>
</head>
<body>
	<%
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
	%>
	<form action="user?q=changePassword" method="post">
		<input type="hidden" name="account" value="<%=user.getAccount()%>">
		<table>
			<tr>
				<td>旧密码：</td>
				<td><input type="password" id="oldPassword" name="oldPassword"></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" id="newPassword" name="newPassword"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="提交"></td>
				<td align="center"><a
					href="<%=request.getContextPath()%>/logout">退出</a></td>
			</tr>
		</table>
	</form>

	<%
		Object result = request.getAttribute("changePasswordResult");
			if (result != null) {
	%>
	<span id="result" style="display: none;"><%=(String) result%></span>
	<%
		}
	%>
	<%
		}
	%>
</body>
</html>