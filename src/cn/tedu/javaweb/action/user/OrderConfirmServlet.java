package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.AddressDao;
import cn.tedu.javaweb.dao.OrderItemDao;
import cn.tedu.javaweb.po.Address;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.vo.OrderItemVo;

@WebServlet("/user/action/OrderConfirmServlet")
public class OrderConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");// orderId
		User user = (User) request.getSession().getAttribute("user");
		AddressDao addressDao = new AddressDao();
		ArrayList<Address> adds = addressDao.selectByUser(user);//getReceverByUser
		OrderItemDao orderItemDao = new OrderItemDao();
		ArrayList<OrderItemVo> orderitem = orderItemDao.selectByIdAssociatedBook(orderId);//getOrderItemsById
		request.setAttribute("adds", adds);
		request.setAttribute("orderitem", orderitem);
		request.setAttribute("orderId", orderId);
		request.getRequestDispatcher("../page/order-confirm.jsp").forward(request, response);
	}

}
