package cn.tedu.javaweb.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.javaweb.dao.UserDao;
import cn.tedu.javaweb.po.User;

@WebServlet("/admin/action/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result =null;
		result = "../page/login.jsp";
		User user = new User();// uname,upwd
		user.setUname(request.getParameter("uname"));
		user.setUpwd(request.getParameter("upwd"));
		user.setRole(1);
		UserDao userDao = new UserDao();
		User u = userDao.selectByNamePasswordAndRole(user);
		if(null!=u){
		  HttpSession session = request.getSession();
		  session.setAttribute("user",u);
		  result = "../page/index.jsp";
		}
		request.getRequestDispatcher(result).forward(request, response);
	}

}
