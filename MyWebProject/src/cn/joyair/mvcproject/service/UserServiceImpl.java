package cn.joyair.mvcproject.service;

import java.sql.Connection;
import java.util.List;

import cn.joyair.mvcproject.dao.FactoryDao;
import cn.joyair.mvcproject.dao.UserDao;
import cn.joyair.mvcproject.model.User;
import cn.joyair.mvcproject.utils.JdbcUtils;

public class UserServiceImpl implements UserService {
//	UserDao userDao = new UserDaoImpl();
	/**
	 * 采用面向接口编程思想：获取接口类型，与具体实现没有关系。
	 * MVC各层之间相对独立，修改一层代码不影响其它层。
	 */
	UserDao userDao = FactoryDao.getUserDao();
	
	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public int deleteUserById(String id) {
		return userDao.deleteUserById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User get(String id) {
		return userDao.get(id);
	}

	/**
	 * service层的意义体现在这里
	 * 不涉及实际操作数据库的业务逻辑代码，都应该写在service层
	 */
	@Override
	public User getTransaction(String id) {
		Connection conn = null;
		User user= null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false); //开启事务
			user = userDao.get(conn, id);
			conn.commit();
		}catch (Exception e) {
			JdbcUtils.rollbackTransaction(conn); //回滚事务
		}
		return user;
	}

	@Override
	public List<User> getListAll() {
		return userDao.getListAll();
	}

	@Override
	public long getCountByName(String username) {
		return userDao.getCountByName(username);
	}

	@Override
	public List<User> getListAll(int gd) {
		return userDao.getListAll(gd);
	}

	@Override
	public List<User> query(String username, String identity, String phone) {

		return userDao.query(username, identity, phone);
	}

	@Override
	public int updateUserById(User user) {
		return userDao.updateUserById(user);
		
	}

	@Override
	public User login(String username, String identity) {
		
		return userDao.getUserByUP(username, identity);
	}

}
