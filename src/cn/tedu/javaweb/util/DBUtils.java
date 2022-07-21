package cn.tedu.javaweb.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtils {
	private static final Logger logger = LogManager.getLogger(DBUtils.class);
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = ds.getConnection();
			logger.info(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void closeResultSet(ResultSet res){
		if(null!=res){
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatement(Statement sta){
		if(null!=sta){
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection con){
		if(null!=con){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
