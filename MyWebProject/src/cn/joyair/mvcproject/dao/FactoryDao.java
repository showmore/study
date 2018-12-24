package cn.joyair.mvcproject.dao;

public class FactoryDao {
	/**
	 * 为了避免Service层与Dao层的耦合性
	 * 避免在Service层中实例化具体对象UserDao userDao = new UserDaoImpl();
	 * @return
	 */
	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
