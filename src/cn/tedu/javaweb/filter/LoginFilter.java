package cn.tedu.javaweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private String contextPath;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		if(isPermitted(servletPath, session)){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect(contextPath+"/"+(servletPath.split("/")[1])+"/page/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		contextPath = fConfig.getServletContext().getContextPath();
	}

	/**
	 * 是否被允许访问
	 * @param path
	 * @param session
	 * @return 允许访问返回true
	 */
	public boolean isPermitted(String path, HttpSession session){
//		return true;
		if(null!=session.getAttribute("user")){
			return true;
		}
		if(path.endsWith(".html") || 
		   path.endsWith(".css") || 
		   path.endsWith(".js") || 
		   path.endsWith(".json") || 
		   path.endsWith(".jpg") || 
		   path.endsWith(".png") || 
		   path.endsWith(".eot") || 
		   path.endsWith(".svg") || 
		   path.endsWith(".ttf") || 
		   path.endsWith(".woff") || 
		   path.endsWith(".woff2") || 
		   path.endsWith(".otf") || 
		   path.endsWith("regist.jsp") || 
		   path.endsWith("login.jsp") || 
		   path.endsWith("LoginServlet") || 
		   path.endsWith("RegistServlet") || 
		   path.endsWith("CheckEmailServlet") || 
		   path.endsWith("CheckPhoneServlet") || 
		   path.endsWith("CheckUnameServlet")){
			return true;
		}
		return false;
	}
}
