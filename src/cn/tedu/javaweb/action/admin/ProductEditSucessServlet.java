package cn.tedu.javaweb.action.admin;

import cn.tedu.javaweb.dao.AddressDao;
import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.dao.OrderDao;
import cn.tedu.javaweb.dao.OrderItemDao;
import cn.tedu.javaweb.po.Address;
import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.Order;
import cn.tedu.javaweb.util.DateConverter;
import cn.tedu.javaweb.vo.OrderItemVo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
@WebServlet("/admin/action/ProductEditSucessServlet")
public class ProductEditSucessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");// orderId
        String title = request.getParameter("title");// orderId
        String author = request.getParameter("author");// orderId
        String price = request.getParameter("price");// orderId
        String press = request.getParameter("press");// orderId
        String edition = request.getParameter("edition");// orderId
        String published = request.getParameter("published");// orderId
        String pages = request.getParameter("pages");// orderId
        String words = request.getParameter("words");// orderId
        String packaging = request.getParameter("packaging");// orderId
        String format = request.getParameter("format");// orderId
        String form = request.getParameter("form");// orderId
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(Double.parseDouble(price));
        book.setPress(press);
        book.setEdition(Integer.parseInt(edition));
        try {
            book.setPublished(DateConverter.parseDate(published));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book.setForm(form);
        book.setPages(Integer.parseInt(pages));
        book.setWords(Integer.parseInt(words));
        book.setFormat(format);
        book.setPackaging(packaging);
        book.setPress(press);

        BookDao bookDao = new BookDao();
        //更新数据
        bookDao.updateBoot(book);
        request.getRequestDispatcher("../page/product-list.jsp").forward(request, response);
    }

}
