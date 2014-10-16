package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Product;

public interface IProductService {
	List<Product> showAllProduct();
	
	Product showDetail(int id);
}
