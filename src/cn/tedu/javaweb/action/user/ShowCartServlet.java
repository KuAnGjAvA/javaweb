package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.CartItemDao;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.vo.CartItemVo;

@WebServlet("/user/action/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		//获取购物车中的所有内容
		CartItemDao cartItemDao = new CartItemDao();
		ArrayList<CartItemVo> cart = cartItemDao.selectByUserAssociatedBook(user);//getCart
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("../page/cart.jsp").forward(request, response);
	}

}
