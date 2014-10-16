package com.briup.estore.bean;

import java.io.Serializable;

/**
 * 订单项或订单明细实体类
 * */
public class OrderLines implements Serializable{
	private int orderlineid;
	private int productid;
	private String productName;
	private double price;
	private int count;
	private double total;
	//标识当前订单项所属的订单id
	private long orderformid;
	public long getOrderformid() {
		return orderformid;
	}
	public void setOrderformid(long orderformid) {
		this.orderformid = orderformid;
	}
	public int getOrderlineid() {
		return orderlineid;
	}
	public void setOrderlineid(int orderlineid) {
		this.orderlineid = orderlineid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
