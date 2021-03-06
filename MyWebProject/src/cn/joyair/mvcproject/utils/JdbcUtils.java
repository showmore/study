package cn.joyair.mvcproject.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	private static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("mysql");
	}
	
	
	public static Connection getConnection() {
		//数据库连接池
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			System.out.println("get conn");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
 	   * 通用关闭数据库连接对象的方法
	 * @param conn
	 */
	public static void closeConn(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
				System.out.println("conn close");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollbackTransaction(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
