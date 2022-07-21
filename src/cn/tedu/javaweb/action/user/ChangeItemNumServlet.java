package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.CartItemDao;

@WebServlet("/user/action/ChangeItemNumServlet")
public class ChangeItemNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String,String> params = new HashMap<String,String>();// itemId,num
		params.put("itemId", request.getParameter("itemId"));
		params.put("num", request.getParameter("num"));
		CartItemDao cartItemDao = new CartItemDao();
		cartItemDao.updateNumById(params);//changeItemNum
	}

}
