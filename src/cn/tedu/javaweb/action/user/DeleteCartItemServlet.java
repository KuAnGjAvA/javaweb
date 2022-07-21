package cn.tedu.javaweb.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.CartItemDao;

@WebServlet("/user/action/DeleteCartItemServlet")
public class DeleteCartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer rid = Integer.parseInt(request.getParameter("itemId"));// itemId
		CartItemDao cartItemDao = new CartItemDao();
		cartItemDao.deleteById(rid);//deleteCartItem;
		request.getRequestDispatcher("../action/ShowCartServlet").forward(request, response);
	}

}
