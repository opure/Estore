package com.briup.estore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.util.ConnectionFactory;

public class OrderFormDaoImpl implements IOrderFormDao{

	@Override
	public void saveOrderForm(OrderForm form) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstat=null;
		String sql="insert into orderform values(?,?,?,?,?)";
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setLong(1, form.getId());
			pstat.setDouble(2, form.getTotal());
			pstat.setString(3, form.getStatus());
			pstat.setString(4, form.getPayway());
			pstat.setInt(5, form.getUsercode());
			pstat.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(null, pstat, conn);
		}
	}

	@Override
	public List<OrderForm> findAllOrderForm(int usercode) {
		// TODO Auto-generated method stub
		String sql="select * from orderform where usercode=? order by id desc";
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		List<OrderForm> list=new ArrayList<OrderForm>();
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, usercode);
			rs=pstat.executeQuery();
			while(rs.next()){
				OrderForm o=new OrderForm();
				o.setId(rs.getLong("id"));
				o.setPayway(rs.getString("payway"));
				o.setStatus(rs.getString("status"));
				o.setTotal(rs.getDouble("total"));
				o.setUsercode(rs.getInt("usercode"));
				list.add(o);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(rs, pstat, conn);
		}
		return list;
	}

	@Override
	public void deleteOrderForm(long orderformid) {
		// TODO Auto-generated method stub
		
	}

}
