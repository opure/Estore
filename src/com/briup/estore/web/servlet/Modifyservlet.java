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

public class Modifyservlet extends HttpServlet {

	private IUserService service=new UserServiceImpl();
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//%E5%8F%91%E6%B5%8B%E8%AF%95
		//仅对post提交有效 对get毫无作用
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//如果是get方法提交 那么需要修改服务器server.xml
		String userid=new String(request.getParameter("userid"));
		String password=new String(request.getParameter("password"));
		String departement=new String(request.getParameter("country"));
		String lianxi1=new String(request.getParameter("street1"));
		String lianxi2=new String(request.getParameter("street2"));
	    String youbian=new String(request.getParameter("zip"));
		String tel=new String(request.getParameter("homephone"));
		String  telphone=new String(request.getParameter("officephone"));
		String shouji=new String(request.getParameter("cellphone"));
		String email=new String(request.getParameter("email"));
		HttpSession session=request.getSession();
		//根据用户输入的名字去数据库查找 如果由此用户 说明用户名不可用
		PrintWriter out = response.getWriter();
	;
		try {	
	     User user=new User();
         user.setUserid(userid);
		 user.setPassword(password);
		 user.setDepartment(departement);
		 user.setLianxi1(lianxi1);
		 user.setLianxi2(lianxi2);
		 user.setYoubian(Integer.parseInt(youbian));
		 user.setTel(Integer.parseInt(tel));
		 user.setTelphone(Integer.parseInt(telphone));
		 user.setShouji(Integer.parseInt(shouji));
		 user.setEmail(email);
	
		 service.updateUser(user);
		 if(user!=null){
			 session.setAttribute("u", user);
			 session.setAttribute("success", "修改成功");
            response.sendRedirect("/es/user/confirmOrder.jsp");
		 }
		 else{
			 response.sendRedirect("/es/user/userinfo,jsp");
		 }
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
