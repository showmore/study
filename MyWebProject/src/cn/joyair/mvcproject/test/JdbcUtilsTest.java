package cn.joyair.mvcproject.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cn.joyair.mvcproject.utils.JdbcUtils;

class JdbcUtilsTest {

	@Test
	void testGetConnection() {
		System.out.println("test conn start begin:");
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}
	
	@Test
	void testCloseConnection() {
		System.out.println("test conn close begin:");
		Connection conn = JdbcUtils.getConnection();
		JdbcUtils.closeConn(conn);

	}

}
