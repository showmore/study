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
	public void insertOnline(Online online) {
		onlineDao.insertOnline(online);
	}
	

	@Override
	public void updateOnline(Online online) {
		onlineDao.updateOnline(online);
		
	}

	@Override
	public void deleteExpiresOnline(List<Online> list) {
		// 遍历这个List集合，删除操作
		if(list!=null && list.size()>0) {
			for(Online ol:list) {
				onlineDao.deleteExpiresOnline(ol.getSsid());
			}
		}
		
	}

	@Override
	public Online getOnlineBySsid(String ssid) {
		return onlineDao.getOnlineBySsid(ssid);
	}


	
}
