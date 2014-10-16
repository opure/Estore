package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Product;

public interface IProductDao {
	/**
	 * 查找所有商品
	 * */
	List<Product> findAllProduct();
	/**
	 * 根据产品ID查询指定商品
	 * */
	Product showDetail(int productId);
}
