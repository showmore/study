package cn.joyair.mvcproject.service;



public class FactoryService {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}

	public static OnlineService getOnlineService() {
		return new OnlineServiceImpl();
	}
	
}
