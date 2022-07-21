package cn.tedu.javaweb.action.admin;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.tedu.javaweb.dao.OrderDao;
import cn.tedu.javaweb.po.Order;

@WebServlet("/admin/action/AllOrderServlet")
public class AllOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int draw = Integer.parseInt(request.getParameter("draw"));// draw,start,length
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        OrderDao orderDao = new OrderDao();
        String sta = request.getParameter("sta");
        int recordsTotal = 0;
        ArrayList<Order> order;
        if (sta == null) {
            recordsTotal = orderDao.selectAllCount();
            order = orderDao.selectAllPaged(start, length);
        } else {
            order = orderDao.selectTarPaged(start, length, sta);
            recordsTotal = orderDao.selectAllCount();

        }
        HashMap<String, Object> value = new HashMap<String, Object>();
        value.put("draw", draw);
        value.put("recordsTotal", recordsTotal);
        value.put("recordsFiltered", recordsTotal);
        value.put("data", order);

        Gson gson = new Gson();
        String jsonstr = gson.toJson(value);
        Writer out = null;
        try {
            out = response.getWriter();
            out.write(jsonstr);
        } finally {
            out.close();
        }
    }
}
