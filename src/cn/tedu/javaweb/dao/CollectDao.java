package cn.tedu.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.tedu.javaweb.po.Collect;
import cn.tedu.javaweb.util.DBUtils;

public class CollectDao {
	public Integer selectByProductAndUserId(String isbn, String phone) {
		Integer rid = null;
		Connection con = DBUtils.getConnection();
		String sql = "select rid from tb_collect "
				+ "where product=? and user_id=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, isbn);
			sta.setString(2, phone);
			res = sta.executeQuery();
			if(res.next()){
				rid = new Integer(res.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return rid;
	}
	
	public void insert(Collect collect) {
		Connection con = DBUtils.getConnection();
		String sql = "insert into tb_collect(user_id,product) "
				+ "values(?,?)";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, collect.getUserId());
			sta.setString(2, collect.getProduct());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}

	public void delete(Collect collect) {
		Connection con = DBUtils.getConnection();
		String sql = "delete from tb_collect "
				+ "where user_id=? and product=?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, collect.getUserId());
			sta.setString(2, collect.getProduct());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
}
