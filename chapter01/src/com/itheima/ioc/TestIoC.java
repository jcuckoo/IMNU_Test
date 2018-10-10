package com.itheima.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
    public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		测试控制反转（IoC）
		UserDao userdao = (UserDao) applicationContext.getBean("userDao");
		userdao.say();
//		测试依赖注入（DI）
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.say();
	}
}
