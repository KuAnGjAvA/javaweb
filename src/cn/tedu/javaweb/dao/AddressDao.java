package cn.tedu.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.tedu.javaweb.po.Address;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.util.DBUtils;

public class AddressDao {
	public void insert(Address address) {
		Connection con = DBUtils.getConnection();
		String sql = "insert into "
				+ "tb_address(user_id,address,added,receiver,receiver_phone) "
				+ "values(?,?,?,?,?)";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, address.getUserId());
			sta.setString(2, address.getAddress());
			sta.setDate(3, new java.sql.Date(address.getAdded().getTime()));
			sta.setString(4, address.getReceiver());
			sta.setString(5, address.getReceiverPhone());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public ArrayList<Address> selectByUser(User user) {
		ArrayList<Address> list = new ArrayList<Address>();
		Address address = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * "
				+ "from tb_address "
				+ "where tb_address.user_id=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getPhone());
			res = sta.executeQuery();
			while(res.next()){
				address = new Address();
				address.setRid(res.getInt("rid"));
				address.setUserId(res.getString("user_id"));
				address.setAddress(res.getString("address"));
				address.setAdded(res.getDate("added"));
				address.setReceiver(res.getString("receiver"));
				address.setReceiverPhone(res.getString("receiver_phone"));
				list.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return list;
	}
	
	public Address selectByOrderId(String orderId) {
		Address address = null;
		Connection con = DBUtils.getConnection();
		String sql = "select tb_address.* "
				+ "from tb_order "
				+ "inner join tb_address "
				+ "on tb_order.address_id=tb_address.rid "
				+ "where tb_order.order_id=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, orderId);
			res = sta.executeQuery();
			if(res.next()){
				address = new Address();
				address.setRid(res.getInt("rid"));
				address.setUserId(res.getString("user_id"));
				address.setAddress(res.getString("address"));
				address.setAdded(res.getDate("added"));
				address.setReceiver(res.getString("receiver"));
				address.setReceiverPhone(res.getString("receiver_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return address;
	}
}
