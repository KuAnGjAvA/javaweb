package cn.tedu.javaweb.action.admin;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.po.Book;

@WebServlet("/admin/action/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int draw = Integer.parseInt(request.getParameter("draw"));// draw,start,length
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		BookDao bookDao = new BookDao();
		int recordsTotal = bookDao.selectTotalCount();
		ArrayList<Book> books = bookDao.selectPage(start,length);
		HashMap<String,Object> value = new HashMap<String,Object>();
		value.put("draw", draw);
		value.put("recordsTotal", recordsTotal);
		value.put("recordsFiltered", recordsTotal);
		value.put("data", books);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String jsonstr = gson.toJson(value);
		Writer out = null; 
		try{
			out = response.getWriter();
			out.write(jsonstr);
		}
		finally{
			out.close();
		}
	}

}
