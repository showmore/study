package cn.joyair.mvcproject.service;

import java.util.List;

import cn.joyair.mvcproject.dao.FactoryDao;
import cn.joyair.mvcproject.dao.OnlineDao;
import cn.joyair.mvcproject.model.Online;

public class OnlineServiceImpl implements OnlineService {
	OnlineDao onlineDao = FactoryDao.getOnlineDao();
	
	@Override
	public List<Online> getAllonline() {
		return onlineDao.getAllonline();
	}

	@Override
	public void insertOinline(Online online) {
		onlineDao.insertOinline(online);
	}

	@Override
	public void updateOnline(Online online) {
		onlineDao.updateOnline(online);
		
	}

	@Override
	public void deleteExpiresOnline(String[] ssidArr) {
		// todo
		
	}

	@Override
	public Online getOnlineBySsid(String ssid) {
		return onlineDao.getOnlineBySsid(ssid);
	}
	
}
