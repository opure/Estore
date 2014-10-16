package com.briup.estore.service;

import com.briup.estore.bean.User;
import com.briup.estore.dao.IUserDao;
import com.briup.estore.dao.UserDaoImpl;
public class UserServiceImpl implements IUserService{
	private IUserDao dao=new UserDaoImpl();
	//根据servlet传来的用户名和密码 决定该有什么样的登录结果
	//如果用户不存在 直接返回null
	//如果用户存在但密码不匹配 返回null
	//如果用户存在且密码正确  返回User对象
	@Override
	public User login(String userid, String password) throws Exception {
		// 用户是否存在 密码是否正确select * from userinfo where userid=
		System.out.println("in service");
		User u=dao.findUserByName(userid);
		if(u!=null){
			//用户输入的密码即password参数 
			//数据库存储的密码即dao层方法返回的user对象中的password
			if(password.equals(u.getPassword())){
				return  u;//将登录成功的用户信息返回出去
			}else{
				//密码错误
				System.out.println("密码错误");
				return null;
			}
			
		}else{
			//用户不存在
			System.out.println("用户名不存在！");
			return null;
		}
	}
	@Override
	public void registerUser(User user) throws Exception {
		User u=dao.findUserByName(user.getUserid());
		if(u!=null){
			//用户已存在
			throw new Exception("用户名已存在！");
		}else{
			//用户名不重复
			dao.saveUser(user);
		}
	}
	@Override
	public void updateUser(User user) throws Exception {
		User u=dao.findUserByName(user.getUserid());
		if(u!=null){
			//用户已存在
			throw new Exception("用户名已存在！");
		}else{
			//用户名不重复
			dao.updateUser(user);
		}
	}
		
	}

