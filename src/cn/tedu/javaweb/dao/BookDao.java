package cn.tedu.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.po.User;
import cn.tedu.javaweb.util.DBUtils;


public class BookDao {

    public ArrayList<Book> selectAll() {
        ArrayList<Book> list = new ArrayList<Book>();
        Book book = null;
        Connection con = DBUtils.getConnection();
        String sql = "select * from tb_book";
        PreparedStatement sta = null;
        ResultSet res = null;
        try {
            sta = con.prepareStatement(sql);
            res = sta.executeQuery();
            while (res.next()) {
                book = new Book();
                book.setAuthor(res.getString("author"));
                book.setEdition(res.getInt("edition"));
                book.setForm(res.getString("form"));
                book.setFormat(res.getString("format"));
                book.setIsbn(res.getString("isbn"));
                book.setPackaging(res.getString("packaging"));
                book.setPages(res.getInt("pages"));
                book.setPress(res.getString("press"));
                book.setPrice(res.getDouble("price"));
                book.setPublished(res.getDate("published"));
                book.setTitle(res.getString("title"));
                book.setWords(res.getInt("words"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResultSet(res);
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
        return list;
    }

    public ArrayList<Book> selectPage(int start, int length) {
        ArrayList<Book> books = new ArrayList<Book>();
        Book b = null;
        Connection con = DBUtils.getConnection();
        String sql = "select * from tb_book "
                + "limit ?,?";
        PreparedStatement sta = null;
        ResultSet res = null;
        try {
//			int begin = (page-1)*pageSize;
            sta = con.prepareStatement(sql);
            sta.setInt(1, start);
            sta.setInt(2, length);
            res = sta.executeQuery();
            while (res.next()) {
                b = new Book();
                b.setAuthor(res.getString("author"));
                b.setEdition(res.getInt("edition"));
                b.setForm(res.getString("form"));
                b.setFormat(res.getString("format"));
                b.setIsbn(res.getString("isbn"));
                b.setPackaging(res.getString("packaging"));
                b.setPages(res.getInt("pages"));
                b.setPress(res.getString("press"));
                b.setPrice(res.getDouble("price"));
                b.setPublished(res.getDate("published"));
                b.setTitle(res.getString("title"));
                b.setWords(res.getInt("words"));
                books.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResultSet(res);
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
        return books;
    }

    public int selectTotalCount() {
        int totalCount = 0;
        Connection con = DBUtils.getConnection();
        String sql = "select count(*) from tb_book";
        PreparedStatement sta = null;
        ResultSet res = null;
        try {
            sta = con.prepareStatement(sql);
            res = sta.executeQuery();
            if (res.next()) {
                totalCount = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResultSet(res);
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
        return totalCount;
    }

    public Book selectByIsbn(Book book) {
        Book b = null;
        Connection con = DBUtils.getConnection();
        String sql = "select * from tb_book "
                + "where isbn=?";
        PreparedStatement sta = null;
        ResultSet res = null;
        try {
            sta = con.prepareStatement(sql);
            sta.setString(1, book.getIsbn());
            res = sta.executeQuery();
            if (res.next()) {
                b = new Book();
                b.setAuthor(res.getString("author"));
                b.setEdition(res.getInt("edition"));
                b.setForm(res.getString("form"));
                b.setFormat(res.getString("format"));
                b.setIsbn(res.getString("isbn"));
                b.setPackaging(res.getString("packaging"));
                b.setPages(res.getInt("pages"));
                b.setPress(res.getString("press"));
                b.setPrice(res.getDouble("price"));
                b.setPublished(res.getDate("published"));
                b.setTitle(res.getString("title"));
                b.setWords(res.getInt("words"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResultSet(res);
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
        return b;
    }

    public ArrayList<Book> selectCollect(User user) {
        ArrayList<Book> books = new ArrayList<Book>();
        Book b = null;
        Connection con = DBUtils.getConnection();
        String sql = "select book.* "
                + "from tb_book book "
                + "inner join tb_collect collect "
                + "on book.isbn=collect.product "
                + "where collect.user_id=?";
        PreparedStatement sta = null;
        ResultSet res = null;
        try {
            sta = con.prepareStatement(sql);
            sta.setString(1, user.getPhone());
            res = sta.executeQuery();
            while (res.next()) {
                b = new Book();
                b.setAuthor(res.getString("author"));
                b.setEdition(res.getInt("edition"));
                b.setForm(res.getString("form"));
                b.setFormat(res.getString("format"));
                b.setIsbn(res.getString("isbn"));
                b.setPackaging(res.getString("packaging"));
                b.setPages(res.getInt("pages"));
                b.setPress(res.getString("press"));
                b.setPrice(res.getDouble("price"));
                b.setPublished(res.getDate("published"));
                b.setTitle(res.getString("title"));
                b.setWords(res.getInt("words"));
                books.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResultSet(res);
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
        return books;
    }

    public void insert(Book book) {
        Connection con = DBUtils.getConnection();
        String sql = "insert into "
                + "tb_book(isbn,title,author,price,press,edition,published,pages,words,packaging,format,form) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sta = null;
        try {
            sta = con.prepareStatement(sql);
            sta.setString(1, book.getIsbn());
            sta.setString(2, book.getTitle());
            sta.setString(3, book.getAuthor());
            sta.setDouble(4, book.getPrice());
            sta.setString(5, book.getPress());
            sta.setInt(6, book.getEdition());
            sta.setDate(7, new java.sql.Date(book.getPublished().getTime()));
            sta.setInt(8, book.getPages());
            sta.setInt(9, book.getWords());
            sta.setString(10, book.getPackaging());
            sta.setString(11, book.getFormat());
            sta.setString(12, book.getForm());
            sta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
    }


    //删除指定的商品编号的书籍
    public void deleteByIsbnBoot(String isbn) {
        Connection con = DBUtils.getConnection();
        String sql = "delete  from tb_book "
                + " where isbn=?";
        PreparedStatement sta = null;
        try {
            sta = con.prepareStatement(sql);
            sta.setString(1, isbn);
            sta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
    }

    //更新书本的基本信息
    public void updateBoot(Book book) {
        Connection con = DBUtils.getConnection();
        // update tb_book set isbn=?,title=?,
        String sql = "update tb_book "
                + "set title=?,author=?,price=?,press=?,edition=?,published=?,pages=?,words=?,packaging=?,format=?,form=?  "
                + "where isbn=?";
        PreparedStatement sta = null;
        try {
            sta = con.prepareStatement(sql);

            sta.setString(1, book.getTitle());
            sta.setString(2, book.getAuthor());
            sta.setDouble(3, book.getPrice());
            sta.setString(4, book.getPress());
            sta.setInt(5, book.getEdition());
            sta.setDate(6, new java.sql.Date(book.getPublished().getTime()));
            sta.setInt(7, book.getPages());
            sta.setInt(8, book.getWords());
            sta.setString(9, book.getPackaging());
            sta.setString(10, book.getFormat());
            sta.setString(11, book.getForm());
            sta.setString(12, book.getIsbn());
            sta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
    }

    //模糊查询
    public ArrayList<Book> selectOne(String title) {

        ArrayList<Book> list = new ArrayList<Book>();
        Book book = null;
        Connection con = DBUtils.getConnection();
        String sql = "select * from tb_book where title like ? ";
        String s = "%" + title + "%";
        PreparedStatement sta = null;
        ResultSet res = null;
        try {
            sta = con.prepareStatement(sql);
            sta.setString(1, s);
            res = sta.executeQuery();
            while (res.next()) {
                book = new Book();
                book.setAuthor(res.getString("author"));
                book.setEdition(res.getInt("edition"));
                book.setForm(res.getString("form"));
                book.setFormat(res.getString("format"));
                book.setIsbn(res.getString("isbn"));
                book.setPackaging(res.getString("packaging"));
                book.setPages(res.getInt("pages"));
                book.setPress(res.getString("press"));
                book.setPrice(res.getDouble("price"));
                book.setPublished(res.getDate("published"));
                book.setTitle(res.getString("title"));
                book.setWords(res.getInt("words"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResultSet(res);
            DBUtils.closeStatement(sta);
            DBUtils.closeConnection(con);
        }
        return list;
    }
}
