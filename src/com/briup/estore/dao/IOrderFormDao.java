package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface IOrderFormDao {
	/**
	 * 保存订单信息
	 * */
	void saveOrderForm(OrderForm form);
	/**
	 * 查看指定用户的所有订单
	 * */
	List<OrderForm> findAllOrderForm(int usercode);
	/**
	 * 删除指定订单
	 * */
	void deleteOrderForm(long orderformid);
}
