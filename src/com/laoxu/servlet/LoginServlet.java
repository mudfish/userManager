package com.laoxu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laoxu.entity.User;
import com.laoxu.service.UserService;
import com.laoxu.service.impl.UserServiceImpl;

/**
 * @author：Dylan
 * @date：2018年12月23日 @description：用户登录控制器
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取登录用户信息
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		// 验证用户信息
		UserService userService = new UserServiceImpl();
		User user = userService.checkUserLogin(account, password);
		// 失败跳转
		if (user == null) {
			System.out.println("用户名密码错误！");
			req.setAttribute("error", "用户名或密码错误！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		System.out.println("登录成功！" + user);
		// 添加session
		req.getSession().setAttribute("user", user);
		// 成功跳转
		resp.sendRedirect(req.getContextPath()+"/user.jsp");
		
	}

}
