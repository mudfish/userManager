package com.laoxu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laoxu.entity.User;
import com.laoxu.service.UserService;
import com.laoxu.service.impl.UserServiceImpl;
import com.laoxu.util.StringUtil;

/**
 * @author：Dylan
 * @date：2018年12月25日 @description：用户注册控制器
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String registerResult = "";
		String account = StringUtil.nullString(req.getParameter("account"));
		String username = StringUtil.nullString(req.getParameter("username"));
		String password = StringUtil.nullString(req.getParameter("password"));
		String cpassword = StringUtil.nullString(req.getParameter("cpassword"));
		
		if(StringUtil.isEmpty(account)||StringUtil.isEmpty(username)||StringUtil.isEmpty(password)||StringUtil.isEmpty(cpassword)) {
			registerResult = "注册信息填写不完整！";
		}
		
		// 两次输入密码是否一致
		if (!password.equals(cpassword)) {
			registerResult = "两次密码输入不一致！";
		}
		
		// 判断账号是否已存在
		int accountNum = userService.checkUserAccount(account);
		if(accountNum>0) {
			registerResult = "账号已存在！";
		}
		
		if (StringUtil.isEmpty(registerResult)) {
			User newUser = new User();
			newUser.setAccount(account);
			newUser.setPassword(password);
			newUser.setUsername(username);
			newUser.setSex("女");
			
			userService.addUser(newUser);
			registerResult = "注册成功！";
		}

		req.setAttribute("registerResult", registerResult);
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
		return;

	}

}
