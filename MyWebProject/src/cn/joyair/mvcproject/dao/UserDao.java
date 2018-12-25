package cn.joyair.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import cn.joyair.mvcproject.model.User;

/**
 * �ƶ�����ֻ���巽������ȥʵ�֣� ��user���й�ϵ�Ĳ�������
 * @author Administrator
 *
 */
public interface UserDao {
	
	/**
	 * ʵ�ֲ���һ���û�����
	 * @param user
	 * @return
	 */
	public int save(User user);
	
	/**
	 * ���������û����ɾ����Ӧ�û�����
	 * @param id
	 * @return
	 */
	public int deleteUserById(String id);
	
	/**
	 * �����û��ɣģ��޸Ķ�Ӧ�û���Ϣ����
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * ����ID����ȡһ������,��װ��User�Ķ���ʵ��
	 * @param id
	 * @return
	 */
	public User get(String id);
	
	/**
	 * 
	 * @param conn
	 * @param id
	 * @return
	 */
	public User get(Connection conn, String id);
	
	/**
	 * ��ȡ�û��б�
	 * @return
	 */
	public List<User> getListAll();
	
	/**
	 * ��ȡ��¼����
	 * @param username
	 * @return
	 */
	public long getCountByName(String username);

	
	public List<User> getListAll(int gd);

	public List<User> query(String username, String identity, String phone);

	public int updateUserById(User user);

	public User getUserByUP(String username, String identity);


	
	
	
	
	
	
	
}

	