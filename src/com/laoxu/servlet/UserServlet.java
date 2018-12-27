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
 * @date：2018年12月23日 
 * @description：用户操作控制器
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String todo = req.getParameter("q");
		
		
		//查询所有用户信息
		if("showAllUser".equals(todo)) {
			List<User> userList = userService.getAllUsers();
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/user.jsp").forward(req, resp);
			return;
		}
		//修改密码
		if("changePassword".equals(todo)) {
			String account = req.getParameter("account");
			String oldPassword = req.getParameter("oldPassword");
			String newPassword = req.getParameter("newPassword");
			User user = userService.checkUserLogin(account, oldPassword);
			String changePasswordResult="";
			if(user==null) {
				changePasswordResult="旧密码错误！";
			}
			
			if(StringUtil.isEmpty(oldPassword)||StringUtil.isEmpty(newPassword)) {
				changePasswordResult="旧密码和新密码不能为空！";
			}
			
			if(StringUtil.isEmpty(changePasswordResult)) {
				user.setPassword(newPassword);
				userService.saveUser(user);
				changePasswordResult="密码修改成功！";
			}
			
			req.setAttribute("changePasswordResult", changePasswordResult);
			req.getRequestDispatcher("/changePassword.jsp").forward(req, resp);
			return;
		}
		
	}

}
