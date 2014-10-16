package com.briup.estore.web.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.User;
import com.briup.estore.service.IUserService;
import com.briup.estore.service.UserServiceImpl;

public class LoginServlet2 extends HttpServlet {
	private IUserService service=new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in servlet!");
		response.setContentType("text/html;charset=utf-8");
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		//服务器上的一段内存空间  可被多个请求共享
		HttpSession session=request.getSession();
		//根据用户名和密码判定是否登录成功  由service判定的
		try {
			User olduser=(User) session.getAttribute("user");
			if(olduser!=null){
				response.sendRedirect("ProductListServlet2");
				return;
			}
			User u=service.login(userid, password);
			if(u!=null){
				//成功
				//由当前servlet请求对应资源 并呈现给用户  
				//用户不需要再次发送请求 也就是浏览器地址保持在当前资源即可 不会发生变化
//				request.getRequestDispatcher("productList.html").forward(request, response);
				//当前servlet以响应的方式告诉用户要跳转到哪个页面
				//用户的浏览器会自动再向该资源发送一次请求 所以地址会变化
				session.setAttribute("user", u);
				response.sendRedirect("ProductListServlet2");
			}else{
				//失败
//				request.setAttribute("error", "登录失败");
				session.setAttribute("error", "滚回去");
//				request.getRequestDispatcher("login.jsp").forward(request, response);
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
