package cn.tedu.javaweb.action.admin;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.UserDao;
import cn.tedu.javaweb.po.User;

@WebServlet("/admin/action/CheckUnameServlet")
public class CheckUnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname"); // uname
		if(null!=uname){
			User user = new User();
			user.setUname(uname);
			user.setRole(1);

			boolean isExisting = false;
			UserDao userDao = new UserDao();
			User u = userDao.selectByUnameAndRole(user);
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
