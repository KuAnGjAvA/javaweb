package cn.tedu.javaweb.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.UserDao;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.vo.UserVo;

@WebServlet("/admin/action/PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();// user.uname,user.upwd,npwd,cpwd
		user.setUname(request.getParameter("user.uname"));
		user.setUpwd(request.getParameter("user.upwd"));
		user.setRole(1);
		UserVo userVo = new UserVo();
		userVo.setNpwd(request.getParameter("npwd"));
		userVo.setUser(user);
		UserDao userDao = new UserDao();
		userDao.updatePassword(userVo);
		request.getRequestDispatcher("../page/login.jsp").forward(request, response);
	}

}
