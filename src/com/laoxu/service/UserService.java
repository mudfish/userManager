package com.laoxu.service;

import java.util.List;

import com.laoxu.entity.User;

/**
 * @author：Dylan
 * @date：2018年12月23日
 * @description：用户服务接口
 */
public interface UserService {
	// 校验用户是否存在
	User checkUserLogin(String account, String password);
	// 查询用户列表
	List<User> getAllUsers();
	// 修改用户
	void saveUser(User user);
	// 新增用户
	void addUser(User user);
	// 检查账号是否存在
	int checkUserAccount(String account);
}
