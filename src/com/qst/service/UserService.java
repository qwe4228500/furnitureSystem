package com.qst.service;

import java.util.List;

import com.qst.entity.User;

public interface UserService {
//登录	
User userlogin(String username,String password);
User getuser(String username);
List<User> getuserlist();
void register(String username,String password);
}
