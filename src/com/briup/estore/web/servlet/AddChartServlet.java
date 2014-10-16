package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ShopCart;

public class AddChartServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			//保证多次调用这个servlet的时候共享一个购物车对象 
			//否则无法记录每次具体添加的数量  session
			ShopCart cart=(ShopCart) session.getAttribute("cart");
			if(cart==null){
				//第一次点击加入购物车按钮  
				//新建一个购物车对象
				cart=new ShopCart();
				cart.addOrderLines(id);
				session.setAttribute("cart", cart);
			}else{
				cart.addOrderLines(id);
			}
			response.sendRedirect("ProductListServlet2");
//			System.out.println(((ShopCart)session.getAttribute("cart")).getCount()+"!!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
