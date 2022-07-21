package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.CartItemDao;
import cn.tedu.javaweb.dao.OrderDao;
import cn.tedu.javaweb.dao.OrderItemDao;
import cn.tedu.javaweb.po.Order;
import cn.tedu.javaweb.po.OrderItem;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.util.DateConverter;

@WebServlet("/user/action/CartToOrderServlet")
public class CartToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemIdsString = request.getParameter("itemIds");// itemIds
		String[] itemIds = itemIdsString.split(",");
		User user = (User) request.getSession().getAttribute("user");
		String phone = user.getPhone();
		//OrderId生成规则：手机号后3位+当前时间的yyyyMMddHHmm形式字符序列
		Order order = new Order();
		order.setOrderId(phone.substring(phone.length()-3)+DateConverter.formatTimestamp(new Date()));
		order.setUserId(phone);
		order.setSta("待处理");
		//createOrder
		CartItemDao cartItemDao = new CartItemDao();
		//联合查询：商品编号、商品数量、商品价格
		//select c.product,c.count,b.price from tb_cart_item c inner join tb_book b on c.product=b.isbn where c.rid in (1,2,3)
		ArrayList<HashMap<String,Object>> mapList = cartItemDao.selectCartItemAssociatedBook(itemIds);//cartItemIds
		//order对象持久化
		OrderDao orderDao = new OrderDao();
		orderDao.insert(order);
		OrderItemDao orderItemDao = new OrderItemDao();
		//构造OrderItem对象并持久化
		OrderItem orderItem = null;
		for(HashMap<String,Object> map:mapList){
			orderItem = new OrderItem();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setProduct((String) map.get("product"));
			orderItem.setCount((Integer) map.get("count"));
			orderItem.setPrice((Double) map.get("price"));
			orderItemDao.insert(orderItem);
		}
		
		request.getRequestDispatcher("../action/OrderConfirmServlet?orderId="+order.getOrderId()).forward(request, response);
	}

}
