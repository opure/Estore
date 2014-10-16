package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Product;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//将从数据库中查到的所有的商品集合放到session里面 然后在页面
		//将每一个商品显示出来
		response.setContentType("text/html;charset=utf-8");
		List<Product> ps=new ArrayList<Product>();
		Product p1=new Product();
		p1.setId(1);
		p1.setName("core");
		p1.setPrice(12.00D);
		
		Product p2=new Product();
		p2.setId(2);
		p2.setName("coreasd");
		p2.setPrice(45.00D);
		ps.add(p1);
		ps.add(p2);
		HttpSession session=request.getSession();
		session.setAttribute("ps", ps);
		response.sendRedirect("productList.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
