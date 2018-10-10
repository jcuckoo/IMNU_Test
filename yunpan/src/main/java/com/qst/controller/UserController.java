package com.qst.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qst.pojo.User;
import com.qst.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	//跳转用户注册页面
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String initRegister() {
		return "register";
	}
	//当用户从登录页面，点击登录按钮时，处理用户登录请求
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User user, Model model) {
		userService.addUser(user);
		return "main";
	}
	//跳转用户登录页面
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String initLogin() {
		return "login";
	}
	//当用户从登录页面，点击登录按钮时，处理用户登录请求
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user, Model model,HttpSession session) {
		User loginUser=userService.login(user);
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:getAllUsers";
		}
		return "login";
	}
	//获取用户列表
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
	public String getAllUsers(Model model) {
		List<User> users=userService.findAll();
		model.addAttribute("users", users);
		return "main";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:../getAllUsers";
	}
}
