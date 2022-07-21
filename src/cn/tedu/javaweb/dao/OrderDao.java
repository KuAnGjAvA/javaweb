package cn.tedu.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.tedu.javaweb.po.Order;
import cn.tedu.javaweb.util.DBUtils;

public class OrderDao {
	public void insert(Order order) {
		Connection con = DBUtils.getConnection();
		String sql = "insert into tb_order(user_id,order_id,sta) "
				+ "values(?,?,?)";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, order.getUserId());
			sta.setString(2, order.getOrderId());
			sta.setString(3, order.getSta());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public void updateOrderById(String orderId, int address, double payment, String status) {
		Connection con = DBUtils.getConnection();
		String sql = "update tb_order set address_id=?,payment=?,sta=?,placed=? "
				+ "where order_id=?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, address);
			sta.setDouble(2, payment);
			sta.setString(3, status);
			sta.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
			sta.setString(5, orderId);
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public Order selectById(String orderId) {
		Order order = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * from tb_order "
				+ "where order_id=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, orderId);
			res = sta.executeQuery();
			if(res.next()){
				order = new Order();
				order.setOrderId(res.getString("order_id"));
				order.setAddressId(res.getString("address_id"));
				order.setRid(res.getInt("rid"));
				order.setSta(res.getString("sta"));
				order.setUserId(res.getString("user_id"));
				order.setPayment(res.getDouble("payment"));
				order.setPlaced(res.getTimestamp("placed"));
				order.setReceipt(res.getTimestamp("receipt"));
				order.setDeliver(res.getTimestamp("deliver"));
				order.setHandover(res.getTimestamp("handover"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return order;
	}

	//查找所有的订单的数目
	public int selectAllCount() {
		int totalCount = 0;
		Connection con = DBUtils.getConnection();
		String sql = "select count(*) "
				+ "from tb_order";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			res = sta.executeQuery();
			if(res.next()){

				totalCount = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return totalCount;
	}

	//查找所有的订单
	public ArrayList<Order> selectAllPaged(int start, int length) {
		ArrayList<Order> list = new ArrayList<Order>();
		Order order = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * from tb_order "
				+ "order by placed desc "
				+ "limit ?,?";
		PreparedStatement stad = null;
		ResultSet res = null;
		try {
			stad = con.prepareStatement(sql);
			stad.setInt(1, start);
			stad.setInt(2, length);
			res = stad.executeQuery();
			while(res.next()){
				order = new Order();
				order.setOrderId(res.getString("order_id"));
				order.setAddressId(res.getString("address_id"));
				order.setRid(res.getInt("rid"));
				order.setSta(res.getString("sta"));
				order.setUserId(res.getString("user_id"));
				order.setPayment(res.getDouble("payment"));
				order.setPlaced(res.getTimestamp("placed"));
				order.setReceipt(res.getTimestamp("receipt"));
				order.setDeliver(res.getTimestamp("deliver"));
				order.setHandover(res.getTimestamp("handover"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(stad);
			DBUtils.closeConnection(con);
		}
		return list;
	}

	//======================================+++++
	//查找指定类型的(已支付，已交付，处理中，待处理，)的订单
	public ArrayList<Order> selectTarPaged(int start, int length,String staString) {
		ArrayList<Order> list = new ArrayList<Order>();
		Order order = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * from tb_order where sta=? "
				+ "order by placed desc "
				+ "limit ?,?";
		PreparedStatement stad = null;
		ResultSet res = null;
		try {
			stad = con.prepareStatement(sql);
			stad.setString(1,staString);
			stad.setInt(2, start);
			stad.setInt(3, length);
			res = stad.executeQuery();
			while(res.next()){
				order = new Order();
				order.setOrderId(res.getString("order_id"));
				order.setAddressId(res.getString("address_id"));
				order.setRid(res.getInt("rid"));
				order.setSta(res.getString("sta"));
				order.setUserId(res.getString("user_id"));
				order.setPayment(res.getDouble("payment"));
				order.setPlaced(res.getTimestamp("placed"));
				order.setReceipt(res.getTimestamp("receipt"));
				order.setDeliver(res.getTimestamp("deliver"));
				order.setHandover(res.getTimestamp("handover"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(stad);
			DBUtils.closeConnection(con);
		}
		return list;
	}

	//=====================================================
	//查找指定类型的(已支付，已交付，处理中，待处理，)的订单的总数
	public int selectCount(String staString) throws SQLException {
		int totalCount = 0;
		Connection con = DBUtils.getConnection();
		String sql = "select count(*) "
				+ "from tb_order "
				+ " where sta=? ";
		PreparedStatement sta = null;



//		stad.setString(1,staString);
//		stad.setInt(2, start);
//		stad.setInt(3, length);


		sta.setString(1,staString);
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			res = sta.executeQuery();
			if(res.next()){
				System.out.println("+=============");
				System.out.println(res.getInt(1));
				System.out.println("+=============");

				totalCount = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return totalCount;
	}


	public void updateStaById(String orderId, String status) {
		Connection con = DBUtils.getConnection();
		String sql = "update tb_order set sta=?,handover=? "
				+ "where order_id=? and sta<>?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, status);
			sta.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
			sta.setString(3, orderId);
			sta.setString(4, status);
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
}
