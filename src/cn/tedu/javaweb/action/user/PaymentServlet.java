package cn.tedu.javaweb.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.OrderDao;

@WebServlet("/user/action/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");// orderId,address,payment
		int address = Integer.parseInt(request.getParameter("address"));
		double payment = Double.parseDouble(request.getParameter("payment"));
		OrderDao orderDao = new OrderDao();
		orderDao.updateOrderById(orderId,address,payment,"待处理");//completePayment
		request.setAttribute("orderId", orderId);
		request.setAttribute("payment", payment);
		request.getRequestDispatcher("../page/payment.jsp").forward(request, response);
	}

}
