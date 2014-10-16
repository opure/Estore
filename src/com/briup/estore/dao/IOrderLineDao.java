package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLines;

public interface IOrderLineDao {
	/**
	 * 保存所有订单
	 * */
	void saveOrderLine(OrderLines orderLines);
	/**
	 * 查看指定订单的详情
	 * */
	List<OrderLines> showOrderLines(long orderformid);
	/**
	 * 删除指定订单关联的所有订单项
	 * */
	void deleteAllOrderLines(long orderformid);
}
