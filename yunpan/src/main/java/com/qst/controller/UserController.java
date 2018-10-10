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
	//��ת�û�ע��ҳ��
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String initRegister() {
		return "register";
	}
	//���û��ӵ�¼ҳ�棬�����¼��ťʱ�������û���¼����
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User user, Model model) {
		userService.addUser(user);
		return "main";
	}
	//��ת�û���¼ҳ��
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String initLogin() {
		return "login";
	}
	//���û��ӵ�¼ҳ�棬�����¼��ťʱ�������û���¼����
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user, Model model,HttpSession session) {
		User loginUser=userService.login(user);
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:getAllUsers";
		}
		return "login";
	}
	//��ȡ�û��б�
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
