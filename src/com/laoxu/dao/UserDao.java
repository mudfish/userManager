package com.laoxu.dao;

import java.util.List;

import com.laoxu.entity.User;

/**
 * @author：Dylan
 * @date：2018年12月23日
 * @description：用户DAO
 */
public interface UserDao {
	User selectUserByAccountAndPassword(String account, String password);
	
	List<User> selectAllUsers();
	
	void updateUser(User user);
	
	void insertUser(User user);
	
	int selectCountByAccount(String account);
}
