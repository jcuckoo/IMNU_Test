package com.itheima.ioc;

public class UserServiceImpl implements UserService {
    @SuppressWarnings("unused")
	private UserDao userDao;
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void say() {
        this.userDao.say();
        System.out.println("222");
	}

}
