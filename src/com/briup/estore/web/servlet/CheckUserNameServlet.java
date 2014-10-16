package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.User;
import com.briup.estore.dao.UserDaoImpl;
/**
 * 接受用户使用ajax发来的用户名 并将判定结果反馈给用户
 * */
public class CheckUserNameServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userid=request.getParameter("userid");
		System.out.println(userid);
		//在此处根据用户输入的用户名 去数据库查找看是否有指定用户
		//此处仅用来描述逻辑判断 不可作为实际代码使用 
		UserDaoImpl dao=new UserDaoImpl();
		User u=dao.findUserByName(userid);
		if(u!=null){
			out.print("用户名不可用");
		}else{
			out.print("用户名可用");
		}
		out.flush();
		out.close();
	}


}
