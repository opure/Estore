package com.briup.estore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.estore.bean.User;
import com.briup.estore.util.ConnectionFactory;

public class UserDaoImpl implements IUserDao{

	@Override
	public User findUserByName(String name) {
		// select * from userinfo where userid=?
		//如果有指定数据 那么该数据将被封装为一个User对象 并返回出去
		//如果没有指定数据  直接返回null
		System.out.println("in dao!");
		String sql="select * from userinfo where userid=?";
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		User u=null;
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, name);
			rs=pstat.executeQuery();
			while(rs.next()){
				//能查到指定数据
				u=new User();
				u.setId(rs.getInt("id"));
				u.setUserid(name);
				u.setPassword(rs.getString("password"));
				u.setLianxi1(rs.getString("lianxi1"));
				u.setLianxi2(rs.getString("lianxi2"));
				u.setYoubian(rs.getInt("youbian"));
				u.setTel(rs.getInt("tel"));
				u.setTelphone(rs.getInt("telphone"));
				u.setShouji(rs.getInt("shouji"));
				u.setEmail(rs.getString("email"));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(rs, pstat, conn);
		}
		return u;
	}

	public void saveUser(User user) { 
		String sql="insert into userinfo values(userinfo_id.nextval,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstat=null;
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, user.getUserid());
			pstat.setString(2, user.getPassword());
			pstat.setString(3,user.getDepartment());
			pstat.setString(4,user.getLianxi1());
			pstat.setString(5,user.getLianxi2());
			pstat.setInt(6,user.getYoubian());
			pstat.setInt(7,user.getTel());
			pstat.setInt(8,user.getTelphone());
			pstat.setInt(9,user.getShouji());
			pstat.setInt(10,user.getYoubian());
			pstat.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(null, pstat, conn);
		}
	}

	@Override
	public void updateUser(User user) {
		String sql="update into userinfo values(userinfo_id.nextval,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstat=null;
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, user.getUserid());
			pstat.setString(2, user.getPassword());
			pstat.setString(3,user.getDepartment());
			pstat.setString(4,user.getLianxi1());
			pstat.setString(5,user.getLianxi2());
			pstat.setInt(6,user.getYoubian());
			pstat.setInt(7,user.getTel());
			pstat.setInt(8,user.getTelphone());
			pstat.setInt(9,user.getShouji());
			pstat.setInt(10,user.getYoubian());
			pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(null, pstat, conn);
		}
	}
		
}




