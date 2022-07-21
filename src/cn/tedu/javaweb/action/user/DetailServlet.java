package cn.tedu.javaweb.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.dao.CollectDao;
import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.vo.BookVo;

@WebServlet("/user/action/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		book.setIsbn(request.getParameter("isbn"));// isbn
		BookDao bookDao = new BookDao();
		Book b = bookDao.selectByIsbn(book);
		User user = (User) request.getSession().getAttribute("user");
		CollectDao collectDao = new CollectDao();
		Integer rid = collectDao.selectByProductAndUserId(book.getIsbn(),user.getPhone());
		BookVo bv = new BookVo();
		bv.setBook(b);
		bv.setRid(rid);
		request.setAttribute("bookVo", bv);
		request.getRequestDispatcher("../page/detail.jsp").forward(request, response);
	}
}
