package cn.tedu.javaweb.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.OrderDao;

@WebServlet("/admin/action/UpdateOrderStaServlet")
public class UpdateOrderStaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");// orderId,ordersta
		String ordersta = request.getParameter("ordersta");
		OrderDao orderDao = new OrderDao();
		orderDao.updateStaById(orderId,ordersta);//changeOrderSta
		request.getRequestDispatcher("../action/OrderProcessServlet?orderId="+orderId).forward(request, response);
	}

}
