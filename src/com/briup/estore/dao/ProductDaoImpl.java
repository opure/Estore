package com.briup.estore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.estore.bean.Product;
import com.briup.estore.util.ConnectionFactory;

public class ProductDaoImpl implements IProductDao{

	@Override
	public List<Product> findAllProduct() {
		List<Product> list=new ArrayList<Product>();
		String sql="select * from product";
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			conn=ConnectionFactory.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(rs, stat, conn);
		}
		return list;
	}

	@Override
	public Product showDetail(int productId) {
		String sql="select * from product where id="+productId;
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		Product p=null;
		try {
			conn=ConnectionFactory.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAuthor(rs.getString("author"));
				p.setCategory(rs.getString("category"));
				p.setContent(rs.getString("content"));
				p.setImage(rs.getString("image"));
				p.setPrice(rs.getDouble("price"));
				p.setPage(rs.getInt("page"));
				p.setPublish(rs.getString("publish"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(rs, stat, conn);
		}
		return p;
	}

}
