package cn.joyair.mvcproject.service;

import java.util.List;

import cn.joyair.mvcproject.model.Online;

public interface OnlineService {
	/**
	 * 取出所有在线访问者信息
	 * @return
	 */
	public List<Online> getAllonline();
	
	/**
	 * 插入一条Online信息
	 * @param online
	 */
	public void insertOnline(Online online);
	
	public void updateOnline(Online online);
	
	public void deleteExpiresOnline(List<Online> list);
	
	public Online getOnlineBySsid(String ssid);


	
}
