package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.User;
import com.briup.estore.dao.IOrderFormDao;
import com.briup.estore.dao.OrderFormDaoImpl;
/**
 * 查看当前用户的历史订单
 * */
public class ListOrderFormServlet extends HttpServlet {
	private IOrderFormDao formDao=new OrderFormDaoImpl();
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		//获取当前在线用户
		User u=(User) session.getAttribute("user");
		//根据当前用户的id提取所有的订单
		List<OrderForm> orderforms=formDao.findAllOrderForm(u.getId());
		session.setAttribute("orderforms", orderforms);
		response.sendRedirect("order.jsp");
	}


}
