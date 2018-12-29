package cn.joyair.mvcproject.service;

import java.util.List;

import cn.joyair.mvcproject.model.Online;

public interface OnlineService {
	/**
	 * ȡ���������߷�������Ϣ
	 * @return
	 */
	public List<Online> getAllonline();
	
	/**
	 * ����һ��Online��Ϣ
	 * @param online
	 */
	public void insertOnline(Online online);
	
	public void updateOnline(Online online);
	
	public void deleteExpiresOnline(List<Online> list);
	
	public Online getOnlineBySsid(String ssid);


	
}
