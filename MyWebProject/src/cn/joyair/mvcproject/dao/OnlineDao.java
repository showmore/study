package cn.joyair.mvcproject.dao;

import java.util.List;

import cn.joyair.mvcproject.model.Online;

public interface OnlineDao {
	/**
	 * 取出所有在线访问者信息
	 * @return
	 */
	public List<Online> getAllonline();
	
	/**
	 * 插入一条Online信息
	 * @param online
	 */
	public void insertOinline(Online online);
	
	public void updateOnline(Online online);
	
	
	public void deleteExpiresOnline(String ssid);
	
	public Online getOnlineBySsid(String ssid);
	
	
}
