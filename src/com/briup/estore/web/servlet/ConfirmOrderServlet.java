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
import com.briup.estore.bean.OrderLines;
import com.briup.estore.bean.ShopCart;
import com.briup.estore.bean.User;
import com.briup.estore.dao.IOrderFormDao;
import com.briup.estore.dao.IOrderLineDao;
import com.briup.estore.dao.OrderFormDaoImpl;
import com.briup.estore.dao.OrderLinesDaoImpl;

public class ConfirmOrderServlet extends HttpServlet {
	//将页面上的所有订单项保存 以及将本次购物生成一个订单 存到数据库中
	private IOrderFormDao formDao=new OrderFormDaoImpl();
	private IOrderLineDao lineDao=new OrderLinesDaoImpl();
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		//获取当前在线用户
		User u=(User) session.getAttribute("user");
		//获取当前购物车  因为里面有要买的东西 也就是本次购物所有的订单项
		ShopCart cart=(ShopCart) session.getAttribute("cart");
		//将本次购物记录生成一个订单对象
		OrderForm orderForm=new OrderForm();
		orderForm.setId(System.currentTimeMillis());
		//记录本次购物的总花销  即订单金额
		orderForm.setTotal(cart.getCost());
		//记录当前订单是属于哪个用户的
		orderForm.setUsercode(u.getId());
			//记录付款方式  此功能暂无
		orderForm.setPayway("先不付钱");
		orderForm.setStatus("xxxx");
		//保存订单  调用service的相关方法
		formDao.saveOrderForm(orderForm);
		
		
		
		//保存每个订单项  并将每个订单项与当前订单关联
		//当前购物车中所有的订单项
		List<OrderLines> orderLines=cart.getOrderlines();
		for (OrderLines orderline : orderLines) {
			//当前订单项对象里面记录了产品的id 名字 价格 数量以及总价
			//如果有两个订单项内容相同 无法区分到底属于哪个订单
			orderline.setOrderformid(orderForm.getId());
			lineDao.saveOrderLine(orderline);
		}
		//提交订单之后记得要清空之前的购物车  避免商品的重复付款
		cart.clearChart();
		//跳转到显示订单的servlet里面
		response.sendRedirect("ListOrderFormServlet");
	}

}
