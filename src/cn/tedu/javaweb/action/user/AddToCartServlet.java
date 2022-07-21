package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.CartItemDao;
import cn.tedu.javaweb.po.CartItem;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.vo.CartItemVo;

@WebServlet("/user/action/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartItem rCartItem = new CartItem();// product,count
		rCartItem.setProduct(request.getParameter("product"));
		rCartItem.setCount(Integer.parseInt(request.getParameter("count")));
		// 获取当前用户信息
		User user = (User) request.getSession().getAttribute("user");
		rCartItem.setUserId(user.getPhone());
		//判断购物车中是否已经有该商品
		CartItemDao cartItemDao = new CartItemDao();
		CartItem cartItem = cartItemDao.selectByUserAndProduct(rCartItem);//getCartItem
		//如果购物车中没有该商品则创建对应的item
		if(null==cartItem){
			cartItem = rCartItem;
			cartItemDao.insert(cartItem);//createCartItem
		}else{
			cartItem.setCount(cartItem.getCount()+rCartItem.getCount());
			cartItemDao.update(cartItem);//modifyCartItem
		}
		//获取购物车中的所有内容
		ArrayList<CartItemVo> cart = cartItemDao.selectByUserAssociatedBook(user);//getCart
		request.setAttribute("cart", cart);
		Writer writer = null;
		try{
			writer = response.getWriter();
			writer.write("yes");
		}
		finally{
			writer.close();
		}
	}

}
