package com.briup.estore.service;

import com.briup.estore.bean.User;

public interface IUserService {
	User login(String userid,String password) throws Exception;
	void registerUser(User user) throws Exception;
	void updateUser(User user)throws Exception;
}
