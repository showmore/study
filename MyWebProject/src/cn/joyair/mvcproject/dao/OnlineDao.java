package cn.joyair.mvcproject.dao;

import java.util.List;

import cn.joyair.mvcproject.model.Online;

public interface OnlineDao {
	/**
	 * ȡ���������߷�������Ϣ
	 * @return
	 */
	public List<Online> getAllonline();
	
	/**
	 * ����һ��Online��Ϣ
	 * @param online
	 */
	public void insertOinline(Online online);
	
	public void updateOnline(Online online);
	
	
	public void deleteExpiresOnline(String ssid);
	
	public Online getOnlineBySsid(String ssid);
	
	
}
