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
	 * ��������ӿڱ��˼�룺��ȡ�ӿ����ͣ������ʵ��û�й�ϵ��
	 * MVC����֮����Զ������޸�һ����벻Ӱ�������㡣
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
	 * service�����������������
	 * ���漰ʵ�ʲ������ݿ��ҵ���߼����룬��Ӧ��д��service��
	 */
	@Override
	public User getTransaction(String id) {
		Connection conn = null;
		User user= null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false); //��������
			user = userDao.get(conn, id);
			conn.commit();
		}catch (Exception e) {
			JdbcUtils.rollbackTransaction(conn); //�ع�����
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
