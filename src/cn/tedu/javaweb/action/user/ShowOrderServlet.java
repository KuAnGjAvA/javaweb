package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.OrderItemDao;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.vo.OrderItemVo;

@WebServlet("/user/action/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));// pageIndex,start,length
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		User user = (User) request.getSession().getAttribute("user");
		OrderItemDao orderItemDao = new OrderItemDao();
		int recordsTotal = orderItemDao.selectCountByUser(user);//totalRecord
		ArrayList<OrderItemVo> order = orderItemDao.selectPagedByUserAssociatedBook(user,start,length);//pagedOrder
		request.setAttribute("pageCount", recordsTotal>0?recordsTotal/length+1:0);
		request.setAttribute("current", pageIndex);
		request.setAttribute("length", length);
		request.setAttribute("order", order);
		request.getRequestDispatcher("../page/order.jsp").forward(request, response);
	}

}
