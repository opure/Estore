package com.briup.estore.dao;

import com.briup.estore.bean.User;

public interface IUserDao {
	User findUserByName(String name);
	void saveUser(User user);
	void updateUser(User user);
}
