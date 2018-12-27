<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.laoxu.entity.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	User currentUser = ((User) session.getAttribute("user"));
	if (currentUser == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<title>用户页面</title>
<script type="text/javascript">
	$(function() {
		$("#btn_showMyInfo").click(function() {
			$("#myinfo").show();
		});
	});
</script>
</head>
<body>
	<%
		if (currentUser != null) {
	%>
	欢迎，<%=currentUser.getUsername()%>！

	<a href="<%=request.getContextPath()%>/logout">退出</a>

	<div style="width: 400px; margin: 20px 20px;">
		<button id="btn_showMyInfo">查看我的信息</button>
		&nbsp;&nbsp; <a
			href="<%=request.getContextPath()%>/user?q=showAllUser">查看所有用户信息</a>&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/changePassword.jsp">修改密码</a>
	</div>


	<!--列出当前登录用户信息-->
	<div id="myinfo"
		style="width: 400px; display: none; margin: 20px 20px;">
		<span>我的信息</span>
		<table border="1">
			<tr>
				<td>账号</td>
				<td>密码</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>邮箱</td>
			</tr>
			<tr>
				<td><%=currentUser.getAccount()%></td>
				<td><%=currentUser.getPassword()%></td>
				<td><%=currentUser.getUsername()%></td>
				<td><%=currentUser.getSex()%></td>
				<td><%=currentUser.getAge()%></td>
				<td><%=currentUser.getEmail()%></td>
			</tr>
		</table>
	</div>

	<!--列出所有用户信息-->
	<%
		List<User> users = (List<User>) request.getAttribute("userList");
			if (users != null && users.size() > 0) {
	%>
	<div id="allinfo" style="width: 400px; margin: 20px 20px;">
		<span>所有用户信息</span>
		<table border="1">
			<tr>
				<td>账号</td>
				<td>密码</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>邮箱</td>
			</tr>

			<c:forEach items="<%=users%>" var="user">
				<tr>
					<td>${user.getAccount()}</td>
					<td>${user.getPassword()}</td>
					<td>${user.getUsername()}</td>
					<td>${user.getSex()}</td>
					<td>${user.getAge()}</td>
					<td>${user.getEmail()}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<%
		}
	%>
	<%
		}
	%>
</body>
</html>