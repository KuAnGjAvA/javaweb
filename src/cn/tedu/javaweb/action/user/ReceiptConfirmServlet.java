package cn.tedu.javaweb.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.OrderDao;

@WebServlet("/user/action/ReceiptConfirmServlet")
public class ReceiptConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");// orderId
		OrderDao orderDao = new OrderDao();
		orderDao.updateStaById(orderId,"已交付");//changeOrderSta
		request.getRequestDispatcher("../action/ShowOrderServlet?pageIndex=1&start=0&length=10").forward(request, response);
	}

}
