package cn.tedu.javaweb.vo;

import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.Order;
import cn.tedu.javaweb.po.OrderItem;

public class OrderItemVo {
	private Order order;
	private OrderItem orderItem;
	private Book book;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
