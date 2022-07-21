package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.CollectDao;
import cn.tedu.javaweb.po.Collect;

@WebServlet("/user/action/CancelCollectServlet")
public class CancelCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collect collect = new Collect();// userId,product
		collect.setUserId(request.getParameter("userId"));
		collect.setProduct(request.getParameter("product"));
		CollectDao collectDao = new CollectDao();
		collectDao.delete(collect);
		Writer writer = null;
		try{
			writer = response.getWriter();
			writer.write("yes");
		}
		finally{
			writer.close();
		}
	}

}
