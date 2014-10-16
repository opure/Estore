package com.briup.estore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.estore.bean.OrderLines;
import com.briup.estore.util.ConnectionFactory;

public class OrderLinesDaoImpl implements IOrderLineDao{

	@Override
	public void saveOrderLine(OrderLines orderLines) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstat=null;
		String sql="insert into orderline values(orderline_id.nextval,?,?,?,?,?,?)";
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, orderLines.getProductid());
			pstat.setString(2, orderLines.getProductName());
			pstat.setDouble(3, orderLines.getPrice());
			pstat.setInt(4, orderLines.getCount());
			pstat.setDouble(5, orderLines.getTotal());
			pstat.setLong(6, orderLines.getOrderformid());
			pstat.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(null, pstat, conn);
		}
	}

	@Override
	public List<OrderLines> showOrderLines(long orderformid) {
		// TODO Auto-generated method stub
		String sql="select * from orderline where orderformid=?";
		List<OrderLines> orderLines=new ArrayList<OrderLines>();
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setLong(1, orderformid);
			rs=pstat.executeQuery();
			while(rs.next()){
				//如果传进来的订单id是有订单项的话
				OrderLines o=new OrderLines();
				o.setOrderlineid(rs.getInt("id"));
				o.setProductName(rs.getString("productname"));
				o.setPrice(rs.getDouble("price"));
				o.setCount(rs.getInt("counts"));
				o.setTotal(rs.getDouble("total"));
				orderLines.add(o);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(rs, pstat, conn);
		}
		return orderLines;
	}
public static void main(String[] args) {
	System.out.println(new OrderLinesDaoImpl().showOrderLines(1408000888759L).size());
}

@Override
public void deleteAllOrderLines(long orderformid) {
	// TODO Auto-generated method stub
	
}
}
