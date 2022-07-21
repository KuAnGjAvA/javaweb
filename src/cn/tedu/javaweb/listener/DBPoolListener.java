package cn.tedu.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBPoolListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBPoolListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        try {
			Class.forName("cn.tedu.javaweb.util.DBUtils");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
}
