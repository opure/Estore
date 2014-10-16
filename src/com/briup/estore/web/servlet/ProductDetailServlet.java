package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Product;
import com.briup.estore.service.IProductService;
import com.briup.estore.service.ProductServiceImpl;
/**
 * 接受用户在产品列表页面上选择的id
 * */
public class ProductDetailServlet extends HttpServlet {
	private IProductService service=new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//接受当前商品的id
		//productDetailServlet?xx=5
		String idString=request.getParameter("id");
		//做非空判断处理空指针
		HttpSession session=request.getSession();
		try {
			int id=Integer.parseInt(idString);//"12" "xxxx"
			Product p=service.showDetail(id);
			if(p==null){
				//代表传过来的id是不存在的商品id
				session.setAttribute("error", "请在商品列表里面选择!");
				request.getRequestDispatcher("ProductListServlet2").forward(request, response);
			}else{
			//将获取到的商品详情显示到指定页面里面
				session.setAttribute("p", p);//${p.name} 
				response.sendRedirect("productDetail.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("error", "请选择有效的商品id");
			request.getRequestDispatcher("ProductListServlet2").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
