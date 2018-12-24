package cn.joyair.mvcproject.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Test;

import cn.joyair.mvcproject.dao.UserDao;
import cn.joyair.mvcproject.dao.UserDaoImpl;
import cn.joyair.mvcproject.model.User;
import cn.joyair.mvcproject.utils.JdbcUtils;

class UserDaoImplTest {

	UserDao userDao = new UserDaoImpl();
	
	@Test
	void getListAll() {
		int gd = 1;
		List<User> user = userDao.getListAll(gd);
		System.out.println(user);
		String typname = user.getClass().getName();
		int length = typname.lastIndexOf(".");
		System.out.println(typname.substring(length+1));
	}
	
	@Test
	void testGetInt() {
		String uid = "d04f942c-2f9e-4eb6-8d32-03d05682c687";
		User user = userDao.get(uid);
		System.out.println(user);
		String typname = user.getClass().getName();
		int length = typname.lastIndexOf(".");
		System.out.println(typname.substring(length+1));
	}

	
	@Test
	void testGetIntT(){
		Connection conn = JdbcUtils.getConnection();
		User user = null;
		String uid = "d04f942c-2f9e-4eb6-8d32-03d05682c687";
		
		try {
			conn.setAutoCommit(false);
			user = userDao.get(conn, uid);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			JdbcUtils.closeConn(conn);
		}
		System.out.println(user);
	}
	
	
	
	
}


