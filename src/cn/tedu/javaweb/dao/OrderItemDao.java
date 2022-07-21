package cn.tedu.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.Order;
import cn.tedu.javaweb.po.OrderItem;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.util.DBUtils;
import cn.tedu.javaweb.vo.OrderItemVo;

public class OrderItemDao {
	public void insert(OrderItem orderItem) {
		Connection con = DBUtils.getConnection();
		String sql = "insert into tb_order_item(product,price,count,order_id) "
				+ "values(?,?,?,?)";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, orderItem.getProduct());
			sta.setDouble(2, orderItem.getPrice());
			sta.setInt(3, orderItem.getCount());
			sta.setString(4, orderItem.getOrderId());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(sta);
			DBUtils.closeConnection(con);
		}
	}

	public ArrayList<OrderItemVo> selectByIdAssociatedBook(String orderId) {
		ArrayList<OrderItemVo> list = new ArrayList<OrderItemVo>();
		Book book = null;
		Order order = null;
		OrderItem orderItem = null;
		OrderItemVo orderItemVo = null;
		Connection con = DBUtils.getConnection();
		String sql = "select item.rid,item.order_id,item.count,item.price oprice,tb_order.sta,book.* "
				+ "from tb_order_item item "
				+ "inner join tb_book book "
				+ "on item.product=book.isbn "
				+ "inner join tb_order "
				+ "on item.order_id=tb_order.order_id "
				+ "where item.order_id=? "
				+ "order by item.order_id desc,item.rid desc";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, orderId);
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
				order = new Order();
				order.setSta(res.getString("sta"));
				orderItem = new OrderItem();
				orderItem.setRid(res.getInt("rid"));
				orderItem.setOrderId(res.getString("order_id"));
				orderItem.setCount(res.getInt("count"));
				orderItem.setPrice(res.getDouble("oprice"));
				orderItem.setProduct(res.getString("isbn"));
				orderItemVo = new OrderItemVo();
				orderItemVo.setBook(book);
				orderItemVo.setOrder(order);
				orderItemVo.setOrderItem(orderItem);
				list.add(orderItemVo);
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
	
	public int selectCountByUser(User user) {
		int totalCount = 0;
		Connection con = DBUtils.getConnection();
		String sql = "select count(*) "
				+ "from tb_order_item item "
				+ "inner join tb_book book "
				+ "on item.product=book.isbn "
				+ "inner join tb_order "
				+ "on item.order_id=tb_order.order_id "
				+ "where tb_order.user_id=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getPhone());
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
	
	public ArrayList<OrderItemVo> selectPagedByUserAssociatedBook(User user, int start, int length) {
		ArrayList<OrderItemVo> list = new ArrayList<OrderItemVo>();
		Book book = null;
		Order order = null;
		OrderItem orderItem = null;
		OrderItemVo orderItemVo = null;
		Connection con = DBUtils.getConnection();
		String sql = "select item.rid,item.order_id,item.count,item.price oprice,tb_order.sta,tb_order.placed,book.* "
				+ "from tb_order_item item "
				+ "inner join tb_book book "
				+ "on item.product=book.isbn "
				+ "inner join tb_order "
				+ "on item.order_id=tb_order.order_id "
				+ "where tb_order.user_id=? "
				+ "order by item.order_id desc,item.rid desc "
				+ "limit ?,?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getPhone());
			sta.setInt(2, start);
			sta.setInt(3, length);
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
				order = new Order();
				order.setSta(res.getString("sta"));
				order.setPlaced(res.getTimestamp("placed"));
				orderItem = new OrderItem();
				orderItem.setRid(res.getInt("rid"));
				orderItem.setOrderId(res.getString("order_id"));
				orderItem.setCount(res.getInt("count"));
				orderItem.setPrice(res.getDouble("oprice"));
				orderItem.setProduct(res.getString("isbn"));
				orderItemVo = new OrderItemVo();
				orderItemVo.setBook(book);
				orderItemVo.setOrder(order);
				orderItemVo.setOrderItem(orderItem);
				list.add(orderItemVo);
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
