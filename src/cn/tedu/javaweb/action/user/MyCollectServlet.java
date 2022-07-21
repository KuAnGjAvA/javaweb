package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.User;

@WebServlet("/user/action/MyCollectServlet")
public class MyCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Book> collects = bookDao.selectCollect(user);
		request.setAttribute("collects", collects);
		request.getRequestDispatcher("../page/collect.jsp").forward(request, response);
	}

}
