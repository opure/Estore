package com.briup.estore.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
/**
 * 用来产生Connection对象的工厂类
 * */
public class ConnectionFactory {
	private static String url;
	private static String driver;
	private static String user;
	private static String password;
	private static Properties prop;
	/**
	 * 初始化获取数据库连接的参数
	 * 通过读取配置文件实现
	 * */
	static{
		try {
			prop=new Properties();
			prop.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			url=prop.getProperty("url");//获取配置文件中指定键的值
			driver=prop.getProperty("driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * 产生Connection对象的方法
	 * @return Connection
	 * */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,prop);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(ConnectionFactory.getConnection());
	}
}
