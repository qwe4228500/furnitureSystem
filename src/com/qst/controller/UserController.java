package com.qst.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qst.entity.User;
import com.qst.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("userlogin.form")
	public String userlogin(HttpSession session,HttpServletRequest req, HttpServletResponse resp, String username, String password) {
		User user = userService.userlogin(username, password);
		if (user != null) {
			session.setAttribute("username", user.getUsername());
			return "success";
		} else {
			return null;
		}

	}
	@RequestMapping("getusername.form")
	public String getusername(HttpSession session,HttpServletRequest req, HttpServletResponse resp) {
		String username = String.valueOf(session.getAttribute("username"));
		
		return username;
		

	}
	@RequestMapping("getuserlist.form")
	public List<User> getuserlist(HttpSession session,HttpServletRequest req, HttpServletResponse resp) {
		return userService.getuserlist();		
	}
	
	@RequestMapping("register.form")
	public String register(HttpServletRequest req, HttpServletResponse resp, String username, String password) {

		User user = userService.getuser(username);
		if (user == null) {
			userService.register(username, password);
			return "success";
		} else {
			return null;
		}

	}
}
