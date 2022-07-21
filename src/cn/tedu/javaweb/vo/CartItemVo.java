package cn.tedu.javaweb.vo;

import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.CartItem;

public class CartItemVo {
	private CartItem cartItem;
	private Book book;
	
	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
