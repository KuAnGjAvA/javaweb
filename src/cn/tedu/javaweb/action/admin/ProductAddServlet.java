package cn.tedu.javaweb.action.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import cn.tedu.javaweb.dao.BookDao;
import cn.tedu.javaweb.po.Book;
import cn.tedu.javaweb.util.DateConverter;

@WebServlet("/admin/action/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==============11进入productAddServlet====");

		//判断提交表单的编码类型是否为multipart/form-data（上传文件必须使用该类型）
		boolean isMulipart = ServletFileUpload.isMultipartContent(request);

		InputStream in = null;
		String fieldName = null;
		FileOutputStream out = null;
		if(isMulipart) {
			ServletFileUpload upload = new ServletFileUpload();
			//把请求中的所有内容转换为一个迭代器（是有序的：按照他们被传送的顺序即表单中的先后顺序）
			try {
				FileItemIterator iterator = upload.getItemIterator(request);
				while(iterator.hasNext()) {
					FileItemStream item = iterator.next();
					try{
						in = item.openStream();//打开对应的流
						fieldName = item.getFieldName();//获取表单域的名
						//判断是不是一个普通表单域
						if(item.isFormField()) {//普通表单域（文本）
							String fieldValue = Streams.asString(in, "UTF-8");//获取表单域的值
//											System.out.println(fieldName + "=" + fieldValue);
							request.setAttribute(fieldName, fieldValue);
						}
						else {//文件表单域
							String fileName = item.getName();//获取文件的名字
							//System.out.println(fileName + "=" + fileName);
							if(null==fileName || "".equals(fileName)){
								continue;
							}
							String path = request.getServletContext().getRealPath("/user/img/goods") + 
									File.separatorChar + 
									request.getAttribute("isbn") + 
									File.separatorChar + 
									fieldName + 
									".jpg";
							File file = new File(path);
							file.getParentFile().mkdir();//不会自动创建依赖但不存在的父目录（此时会报错），mkdirs()会
							file.createNewFile();//不会自动创建依赖但不存在的目录（此时会报错）
							out = new FileOutputStream(file);
							byte buf[] = new byte[1024];
							int len = 0;
							while((len = in.read(buf)) != -1) {
								out.write(buf,0,len);
							}
						}
					} finally{
						if(null != out) {
							out.close();
						}
						if(null != in) {
							in.close();
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		Book book = new Book();
		book.setAuthor(request.getAttribute("author").toString());
		book.setEdition(Integer.parseInt(request.getAttribute("edition").toString()));
		book.setForm(request.getAttribute("form").toString());
		book.setFormat(request.getAttribute("format").toString());
		book.setIsbn(request.getAttribute("isbn").toString());
		book.setPackaging(request.getAttribute("packaging").toString());
		book.setPages(Integer.parseInt(request.getAttribute("pages").toString()));
		book.setPress(request.getAttribute("press").toString());
		book.setPrice(Double.parseDouble(request.getAttribute("price").toString()));
		try {
			book.setPublished(DateConverter.parseDate(request.getAttribute("published").toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book.setTitle(request.getAttribute("title").toString());
		book.setWords(Integer.parseInt(request.getAttribute("words").toString()));
			BookDao bookDao = new BookDao();
			bookDao.insert(book);
		System.out.println("==============22进入productAddServlet====");
		request.getRequestDispatcher("../page/product-list.jsp").forward(request, response);

	}

}
