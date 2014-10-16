package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Product;
import com.briup.estore.dao.IProductDao;
import com.briup.estore.dao.ProductDaoImpl;

public class ProductServiceImpl implements IProductService{
	private IProductDao dao=new ProductDaoImpl();
	@Override
	public List<Product> showAllProduct() {
		// TODO Auto-generated method stub
		return dao.findAllProduct();
	}
	@Override
	public Product showDetail(int id) {
		// TODO Auto-generated method stub
		return dao.showDetail(id);
	}

}
