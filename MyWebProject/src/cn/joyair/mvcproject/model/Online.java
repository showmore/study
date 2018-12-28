package cn.joyair.mvcproject.model;

import java.util.Date;

public class Online {
	private String ssid;
	private String username;
	private String page;
	private String ip;
	private Date time;
	
	public Online() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Online(String ssid, String username, String page, String ip, Date time) {
		super();
		this.ssid = ssid;
		this.username = username;
		this.page = page;
		this.ip = ip;
		this.time = time;
	}


	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Online [ssid=" + ssid + ", username=" + username + ", page=" + page + ", ip=" + ip + ", time=" + time
				+ "]";
	}
	
	
	
	
}
