package com.qst.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qst.pojo.User;
import com.qst.rowMapper.UserMapper;
@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int save(User user) {
		String sql = "insert into t_user(userName,userPwd,headPic,sex,birthday) values(?,?,?,?,?)";
		Object[] params = { user.getUserName(), user.getUserPwd(), user.getHeadPic(), user.getSex(),
				user.getBirthday() };
		return jdbcTemplate.update(sql, params);
	}
	public User findByNameAndPwd(User user) {
		String sql="select * from t_user where userName=? and userPwd=?";
		Object[]params= {user.getUserName(), user.getUserPwd()};
		return jdbcTemplate.queryForObject(sql, params,new UserMapper());
	}
	public List<User> findAll() {
		String sql="select * from t_user";
		return jdbcTemplate.query(sql, new UserMapper());
	}
	public int deleteById(int id) {
		String sql="delete from t_user where id=?";
		Object[] params = { id };
		return jdbcTemplate.update(sql, params);
	}
}
