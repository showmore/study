package cn.joyair.mvcproject.service;

public class FactoryService {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}
}
