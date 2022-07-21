package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.UserDao;
import cn.tedu.javaweb.po.User;

@WebServlet("/user/action/CheckEmailServlet")
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");// email
		if(null!=email){
			User user = new User();
			user.setEmail(email);
			user.setRole(0);

			boolean isExisting = false;
			UserDao userDao = new UserDao();
			User u = userDao.selectByEmailAndRole(user);
			if(null!=u){
				isExisting = true;
			}
			
			Writer out = null; 
			try{
				out = response.getWriter();
				if(isExisting){
					out.write("yes");
				}else{
					out.write("no");
				}
			}
			finally{
				out.close();
			}
		}
	}

}
