package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ShopCart;
/**
 * 更新购物车信息
 * */
public class UpdateCartServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		try {
			//获取商品id
			int productid=Integer.parseInt(request.getParameter("productid"));
			//获取页面修改数量
			int num=Integer.parseInt(request.getParameter("num"));
			ShopCart cart=(ShopCart) session.getAttribute("cart");
			cart.updateChart(productid, num);
			request.getRequestDispatcher("shopcart.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("shopcart.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
