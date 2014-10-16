package com.briup.estore.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.briup.estore.dao.IProductDao;
import com.briup.estore.dao.ProductDaoImpl;

/**
 * 购物车实现类 记录商品购买件数
 * */
public class ShopCart {
	//key代表商品id  value代表商品件数  1-1 2-1
	private Map<Integer, Integer> map=new HashMap<Integer, Integer>();
	public void addOrderLines(int productId){
		//每次向购物车添加新商品的时候都调用此方法
		//如果传来的id在map中不存在 那么记录为1
		//如果已存在 在原有的基础上+1
		Integer count=map.get(productId);
		if(count==null){
			//第一次添加
			map.put(productId, 1);
		}else{
			//不是第一次添加 在原有的基础上+1
			map.put(productId, ++count);
		}
//		System.out.println(map.size()+"=="+map.get(5)+"=="+map.get(6));
	}
	public List<OrderLines> getOrderlines(){
		//返回购物车中所有的订单明细
		List<OrderLines> list=new ArrayList<OrderLines>();
		IProductDao dao=new ProductDaoImpl();
		//遍历map的key 根据每个商品id提取具体的商品对象
		//封装为orderline对象 并放置到集合中
		for (int a : map.keySet()) {
			//a代表每一个商品的id
			//查找指定商品的详细信息
			Product p=dao.showDetail(a);
			//获得当前商品的购买数量
			int count=map.get(a);
			//根据当前商品以及购买数量生成一个订单项对象
			OrderLines o=new OrderLines();
			o.setProductid(p.getId());
			o.setProductName(p.getName());
			o.setPrice(p.getPrice());
			o.setCount(count);
			o.setTotal(p.getPrice()*count);
			list.add(o);
		}
		return list;
	}
	public double getCost(){
		//计算购物车中所有商品的总价
		List<OrderLines>list=getOrderlines();
		double sum=0;
		for (OrderLines o : list) {
			sum+=o.getTotal();
		}
		return sum;
	}
	public void updateChart(int productid,int number){
		map.put(productid, number);
	}
	public void removeProduct(int productid){
		map.remove(productid);
	}
	public void clearChart(){
		map.clear();
	}
	public int getCount(){
		return map.size();
	}
}
