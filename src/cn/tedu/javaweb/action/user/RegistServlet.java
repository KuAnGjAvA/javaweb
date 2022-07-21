package cn.tedu.javaweb.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.UserDao;
import cn.tedu.javaweb.po.User;

@WebServlet("/user/action/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();// uname,upwd,email,phone
		user.setUname(request.getParameter("uname"));
		user.setUpwd(request.getParameter("upwd"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setRole(0);
		
		UserDao userDao = new UserDao();
		userDao.insert(user);
		
		request.getRequestDispatcher("../page/login.jsp").forward(request, response);
	}

}
