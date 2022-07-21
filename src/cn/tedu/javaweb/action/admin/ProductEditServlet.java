package cn.tedu.javaweb.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.po.Book;

@WebServlet("/admin/action/ProductEditServlet")
public class ProductEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");// isbn
        Book book = new Book();
        book.setIsbn(isbn);
        BookDao bookDao = new BookDao();
        Book b = bookDao.selectByIsbn(book);
        request.setAttribute("book", b);
        request.getRequestDispatcher("../page/product-edit.jsp").forward(request, response);
    }

}

