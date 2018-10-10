package com.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qst.dao.UserDao;
import com.qst.pojo.User;

@Service

public class UserService {
	@Autowired
	UserDao userDao;
	@Transactional
	public int addUser(User user) {
		return userDao.save(user);
	}
	public User login(User user) {
		return userDao.findByNameAndPwd(user);
	}
	public List<User> findAll() {
		return userDao.findAll();
	}
	public int deleteUser(int id) {
		return userDao.deleteById(id);
	}
}
