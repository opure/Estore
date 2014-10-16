package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.OrderLines;
import com.briup.estore.dao.IOrderLineDao;
import com.briup.estore.dao.OrderLinesDaoImpl;
/**
 * 根据页面上传来的订单id提取对应的订单明细
 * */
public class ShowOrderFormDetailServlet extends HttpServlet {
	private IOrderLineDao dao=new OrderLinesDaoImpl();
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		try {
			long orderid=Long.parseLong(request.getParameter("orderid"));
			List<OrderLines> orderLines=dao.showOrderLines(orderid);
			session.setAttribute("orderlines", orderLines);
			//user/ShowOrderFormDetailServlet
			//user/orderinfo.jsp
			response.sendRedirect("orderinfo.jsp");
		} catch (Exception e) {
			//404  error-page
			e.printStackTrace();
			response.sendRedirect("/es/error.jsp");
		}
	}

}
