package cn.tedu.javaweb.action.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.dao.UserDao;
import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.User;

@WebServlet("/user/action/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        String search = request.getParameter("search").trim();

        ArrayList<Book> books;
        if (search == null || search.equals("")) {
            books = bookDao.selectAll();
        } else {
            books = bookDao.selectOne(search);
        }


        request.setAttribute("books", books);
        request.getRequestDispatcher("../page/searchbook.jsp").forward(request, response);
    }

}
