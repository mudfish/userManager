package com.laoxu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laoxu.dao.UserDao;
import com.laoxu.entity.User;
import com.laoxu.util.DBUtil;

/**
 * @author：Dylan
 * @date：2018年12月23日
 * @description：
 */
public class UserDaoImpl implements UserDao{
	/**
	 * 根据账号和密码查找用户
	 * @param account
	 * @param password
	 * @return
	 */
	@Override
	public User selectUserByAccountAndPassword(String account, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user where account=? and password=?";
		User user = null;
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(account);
				user.setPassword(password);
				user.setUsername(rs.getString("username"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return user;
	}

	/**
	 * 获取所有用户
	 * @return
	 */
	@Override
	public List<User> selectAllUsers() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user";
		List<User> userList = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return userList;
	}


	/**
	 * 修改用户
	 * @param user
	 */
	@Override
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update t_user set account=?,password=?,username=?,sex=?,age=?,email=? where id=?";
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getSex());
			ps.setInt(5, user.getAge());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

	/**
	 * 统计账号个数
	 * @param account
	 * @return
	 */
	@Override
	public int selectCountByAccount(String account) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) as cnt from t_user where account=?";
		int count=0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
				
		return count;
	}

	/**
	 * @param user
	 */
	@Override
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into t_user(account,password,username,sex) values(?,?,?,?)";
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getSex());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

}
