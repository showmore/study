package cn.joyair.mvcproject.dao;

public class FactoryDao {
	/**
	 * Ϊ�˱���Service����Dao��������
	 * ������Service����ʵ�����������UserDao userDao = new UserDaoImpl();
	 * @return
	 */
	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
