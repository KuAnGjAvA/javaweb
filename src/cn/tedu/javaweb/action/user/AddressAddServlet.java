package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.AddressDao;
import cn.tedu.javaweb.po.Address;
import cn.tedu.javaweb.po.User;

@WebServlet("/user/action/AddressAddServlet")
public class AddressAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address address = new Address();// address,receiver,receiverPhone
		address.setAddress(request.getParameter("address"));
		address.setReceiver(request.getParameter("receiver"));
		address.setReceiverPhone(request.getParameter("receiverPhone"));
		address.setAdded(new Date());
		address.setUserId(((User) request.getSession().getAttribute("user")).getPhone());
		AddressDao addressDao = new AddressDao();
		addressDao.insert(address);
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
