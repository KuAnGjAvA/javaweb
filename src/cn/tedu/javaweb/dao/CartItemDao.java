package cn.tedu.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.CartItem;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.util.DBUtils;
import cn.tedu.javaweb.vo.CartItemVo;

public class CartItemDao {
	public CartItem selectByUserAndProduct(CartItem cartItem) {
		CartItem item = null;
		Connection con = DBUtils.getConnection();
		String sql = "select rid,user_id userId,product,count "
				+ "from tb_cart_item item "
				+ "where product=? and user_id=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, cartItem.getProduct());
			sta.setString(2, cartItem.getUserId());
			res = sta.executeQuery();
			if(res.next()){
				item = new CartItem();
				item.setCount(res.getInt("count"));
				item.setProduct(res.getString("product"));
				item.setRid(res.getInt("rid"));
				item.setUserId(res.getString("userId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeResultSet(res);
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
		return item;
	}
	
	public void insert(CartItem cartItem) {
		Connection con = DBUtils.getConnection();
		String sql = "insert into "
				+ "tb_cart_item(user_id,product,count) "
				+ "values(?,?,?)";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, cartItem.getUserId());
			sta.setString(2, cartItem.getProduct());
			sta.setInt(3, cartItem.getCount());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}

	public void update(CartItem cartItem) {
		Connection con = DBUtils.getConnection();
		String sql = "update tb_cart_item set count=? "
				+ "where product=? and user_id=?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, cartItem.getCount());
			sta.setString(2, cartItem.getProduct());
			sta.setString(3, cartItem.getUserId());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public ArrayList<CartItemVo> selectByUserAssociatedBook(User user) {
		ArrayList<CartItemVo> list = new ArrayList<CartItemVo>();
		Book book = null;
		CartItem cartItem = null;
		CartItemVo cartItemVo = null;
		Connection con = DBUtils.getConnection();
		String sql = "select book.*,item.count,item.user_id,item.rid " 
				+ "from tb_cart_item item "
				+ "inner join tb_book book "
				+ "on item.product=book.isbn "
				+ "where item.user_id=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getPhone());
			res = sta.executeQuery();
			while(res.next()){
				book = new Book();
				book.setAuthor(res.getString("author"));
				book.setEdition(res.getInt("edition"));
				book.setForm(res.getString("form"));
				book.setFormat(res.getString("format"));
				book.setIsbn(res.getString("isbn"));
				book.setPackaging(res.getString("packaging"));
				book.setPages(res.getInt("pages"));
				book.setPress(res.getString("press"));
				book.setPrice(res.getDouble("price"));
				book.setPublished(res.getDate("published"));
				book.setTitle(res.getString("title"));
				book.setWords(res.getInt("words"));
				cartItem = new CartItem();
				cartItem.setCount(res.getInt("count"));
				cartItem.setUserId(res.getString("user_id"));
				cartItem.setRid(res.getInt("rid"));
				cartItemVo = new CartItemVo();
				cartItemVo.setBook(book);
				cartItemVo.setCartItem(cartItem);
				list.add(cartItemVo);
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
	
	public void updateNumById(HashMap<String, String> params) {
		Connection con = DBUtils.getConnection();
		String sql = "update tb_cart_item set count=? "
				+ "where rid=?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(params.get("num")));
			sta.setInt(2, Integer.parseInt(params.get("itemId")));
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public void deleteById(Integer rid) {
		Connection con = DBUtils.getConnection();
		String sql = "delete from tb_cart_item "
				+ "where rid=?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, rid);
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}
	
	public ArrayList<HashMap<String, Object>> selectCartItemAssociatedBook(String[] cartItemIds) {
		StringBuilder sql = new StringBuilder("select c.product,c.count,b.price "
				+ "from tb_cart_item c "
				+ "inner join tb_book b "
				+ "on c.product=b.isbn "
				+ "where 1=1");
		Integer[] cartItemIdsValue = new Integer[cartItemIds.length];
		if(cartItemIds.length>0){
			sql.append(" and c.rid in (");
			for(int i=0;i<cartItemIds.length;i++){
				sql.append("?");
				if(i<cartItemIds.length-1){
					sql.append(",");
				}
				cartItemIdsValue[i] = Integer.parseInt(cartItemIds[i]);
			}
			sql.append(")");
		}
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = null;
		Connection con = DBUtils.getConnection();
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql.toString());
			for(int i=0;i<cartItemIdsValue.length;i++){
				sta.setInt((i+1), cartItemIdsValue[i]);
			}
			res = sta.executeQuery();
			while(res.next()){
				map = new HashMap<String, Object>();
				map.put("product", res.getString("product"));
				map.put("count", res.getInt("count"));
				map.put("price", res.getDouble("price"));
				list.add(map);
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
}
