package cn.tedu.javaweb.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.AddressDao;
import cn.tedu.javaweb.dao.OrderDao;
import cn.tedu.javaweb.dao.OrderItemDao;
import cn.tedu.javaweb.po.Address;
import cn.tedu.javaweb.po.Order;
import cn.tedu.javaweb.vo.OrderItemVo;

@WebServlet("/admin/action/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");// orderId
		
		OrderItemDao orderItemDao = new OrderItemDao();
		ArrayList<OrderItemVo> orderitem = orderItemDao.selectByIdAssociatedBook(orderId);//getOrderItemsById
		
		OrderDao orderDao = new OrderDao();
		Order orderinfo = orderDao.selectById(orderId);//getOrderById

		AddressDao addressDao = new AddressDao();
		Address address = addressDao.selectByOrderId(orderId);//getReceiver
		request.setAttribute("orderitem", orderitem);
		request.setAttribute("orderinfo", orderinfo);
		request.setAttribute("address", address);
		request.getRequestDispatcher("../page/order-detail.jsp").forward(request, response);
	}

}
