package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.dao.OrderDao;
import cn.tedu.javaweb.dao.OrderItemDao;
import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.Order;
import cn.tedu.javaweb.po.OrderItem;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.util.DateConverter;

@WebServlet("/user/action/BuyNowServlet")
public class BuyNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");// product,count
		String count = request.getParameter("count");
		User user = (User) request.getSession().getAttribute("user");
		String phone = user.getPhone();
		//OrderId生成规则：手机号后3位+当前时间的yyyyMMddHHmm形式字符序列
		Order order = new Order();
		order.setOrderId(phone.substring(phone.length()-3)+DateConverter.formatTimestamp(new Date()));
		order.setUserId(phone);
		order.setSta("待处理");
		
		BookDao bookDao = new BookDao();
		Book book = new Book();
		book.setIsbn(product);
		Book b = bookDao.selectByIsbn(book);
		OrderDao orderDao = new OrderDao();
		//order对象持久化
		orderDao.insert(order);
		OrderItemDao orderItemDao =new OrderItemDao();
		//构造OrderItem对象并持久化
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(order.getOrderId());
		orderItem.setProduct(product);
		orderItem.setCount(Integer.parseInt(count));
		orderItem.setPrice(b.getPrice());
		orderItemDao.insert(orderItem);//createOrder
		request.getRequestDispatcher("../action/OrderConfirmServlet?orderId="+order.getOrderId()).forward(request, response);
	}

}
