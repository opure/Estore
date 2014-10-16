package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Product;
import com.briup.estore.service.IProductService;
import com.briup.estore.service.ProductServiceImpl;

public class ProductListServlet2 extends HttpServlet {
	private IProductService service=new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Product> ps=service.showAllProduct();
		HttpSession session=request.getSession();
		session.setAttribute("ps", ps);
		// 内部跳转里面/代表当前项目的根目录
		request.getRequestDispatcher("/WEB-INF/jsp/productList.jsp").forward(request, response);
//		response.sendRedirect("productList.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
