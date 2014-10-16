package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 负责接受用户输入的数据 然后根据处理结果决定跳转页面
 * */
public class LoginServlet extends HttpServlet {
	//处理get请求的
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//获取响应对象的输出流  即可以写到浏览器上的那个流
		PrintWriter out = response.getWriter();
		//可以将括号里面的内容写到浏览器上
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		//upper
		System.out.println("xx".toUpperCase());
		if("zhengzhou".equals(userid)&&"zhengzhou".equals(password)){
			//跳转到index.jsp ../  绝对路径写法
			//  /代表服务器的根目录 在服务器上查找名为es的项目  从改项目下查找index.jsp
			response.sendRedirect("/es/index.jsp");
		}else{
			//跳转到login.jsp  相对路径写法
			//在当前资源所在的上一级目录  
			///es/servlet/LoginServlet
			//去es目录下去寻找login.jsp
			response.sendRedirect("../login.jsp");
		}
		out.flush();
		out.close();
	}


}
