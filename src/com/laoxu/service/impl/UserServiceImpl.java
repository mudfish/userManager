package com.laoxu.service.impl;

import java.util.List;

import com.laoxu.dao.UserDao;
import com.laoxu.dao.impl.UserDaoImpl;
import com.laoxu.entity.User;
import com.laoxu.service.UserService;

/**
 * @author：Dylan
 * @date：2018年12月23日
 * @description：
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * @param account
	 * @param password
	 * @return
	 */
	@Override
	public User checkUserLogin(String account, String password) {
		return userDao.selectUserByAccountAndPassword(account, password);
	}

	/**
	 * @return
	 */
	@Override
	public List<User> getAllUsers() {
		return userDao.selectAllUsers();
	}

	/**
	 * @param user
	 */
	@Override
	public void saveUser(User user) {
		userDao.updateUser(user);
	}

	/**
	 * @param account
	 * @return
	 */
	@Override
	public int checkUserAccount(String account) {
		return userDao.selectCountByAccount(account);
	}

	/**
	 * @param user
	 */
	@Override
	public void addUser(User user) {
		userDao.insertUser(user);
	}

}
