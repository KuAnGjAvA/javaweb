package cn.tedu.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.util.DBUtils;
import cn.tedu.javaweb.vo.UserVo;

public class UserDao {
	
	public void insert(User user){
		Connection con = DBUtils.getConnection();
		String sql = "insert into tb_user(phone,uname,upwd,email,role) "
				+ "values(?,?,?,?,?)";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getPhone());
			sta.setString(2, user.getUname());
			sta.setString(3, user.getUpwd());
			sta.setString(4, user.getEmail());
			sta.setInt(5, user.getRole());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public User selectByNamePasswordAndRole(User user) {
		User u = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * from tb_user "
				+ "where uname=? and upwd=? and role=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getUname());
			sta.setString(2, user.getUpwd());
			sta.setInt(3, user.getRole());
			res = sta.executeQuery();
			if(res.next()){
				u = new User();
				u.setEmail(res.getString("email"));
				u.setPhone(res.getString("phone"));
				u.setRole(res.getInt("role"));
				u.setUname(res.getString("uname"));
				u.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return u;
	}

	public void updatePassword(UserVo userVo) {
		Connection con = DBUtils.getConnection();
		String sql = "update tb_user set upwd=? "
				+ "where uname=? and upwd=? and role=?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, userVo.getNpwd());
			sta.setString(2, userVo.getUser().getUname());
			sta.setString(3, userVo.getUser().getUpwd());
			sta.setInt(4, userVo.getUser().getRole());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public User selectByEmailAndRole(User user){
		User u = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * from tb_user "
				+ "where email=? and role=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getEmail());
			sta.setInt(2, user.getRole());
			res = sta.executeQuery();
			if(res.next()){
				u = new User();
				u.setEmail(res.getString("email"));
				u.setPhone(res.getString("phone"));
				u.setRole(res.getInt("role"));
				u.setUname(res.getString("uname"));
				u.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return u;
	}
	
	public User selectByPhoneAndRole(User user){
		User u = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * from tb_user "
				+ "where phone=? and role=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getPhone());
			sta.setInt(2, user.getRole());
			res = sta.executeQuery();
			while(res.next()){
				u = new User();
				u.setEmail(res.getString("email"));
				u.setPhone(res.getString("phone"));
				u.setRole(res.getInt("role"));
				u.setUname(res.getString("uname"));
				u.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return u;
	}
	
	public User selectByUnameAndRole(User user){
		User u = null;
		Connection con = DBUtils.getConnection();
		String sql = "select * from tb_user "
				+ "where uname=? and role=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getUname());
			sta.setInt(2, user.getRole());
			res = sta.executeQuery();
			if(res.next()){
				u = new User();
				u.setEmail(res.getString("email"));
				u.setPhone(res.getString("phone"));
				u.setRole(res.getInt("role"));
				u.setUname(res.getString("uname"));
				u.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return u;
	}
}
