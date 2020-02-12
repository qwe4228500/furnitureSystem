package com.qst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.UserMapper;
import com.qst.entity.User;
import com.qst.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public User userlogin(String username, String password) {
		// TODO Auto-generated method stub
		return userMapper.userlogin(username, password);
	}

	@Override
	public User getuser(String username) {
		// TODO Auto-generated method stub
		return userMapper.getuser(username);
	}

	public void register(String username, String password) {
		// TODO Auto-generated method stub
		  userMapper.register(username, password);
		
	}

	@Override
	public List<User> getuserlist() {
		// TODO Auto-generated method stub
		return userMapper.getuserlist();
	}
	


}
