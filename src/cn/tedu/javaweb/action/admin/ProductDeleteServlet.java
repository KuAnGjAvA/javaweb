package cn.tedu.javaweb.action.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.po.Book;

@WebServlet("/admin/action/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");// isbn

        BookDao bookDao = new BookDao();
        bookDao.deleteByIsbnBoot(isbn);
        request.getRequestDispatcher("../page/product-list.jsp").forward(request, response);
    }

}


