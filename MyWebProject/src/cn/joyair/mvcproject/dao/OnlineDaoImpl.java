package cn.joyair.mvcproject.dao;

import java.util.List;

import cn.joyair.mvcproject.model.Online;

public class OnlineDaoImpl extends BaseDao<Online> implements OnlineDao {

	@Override
	public List<Online> getAllonline() {
		String sql = "SELECT `SSID`,`USERNAME`,`PAGE`,`IP`,`TIME` FROM `ONLINE`";
		return super.getList(sql);
	}

	@Override
	public void insertOnline(Online online) {
		String sql = "INSERT `ONLINE` SET `SSID`=?, "
				+ "`USERNAME`=?, `PAGE`=?, `IP`=?";
		super.update(sql, online.getSsid(),online.getUsername(),
				online.getPage(),online.getIp());
	}

	@Override
	public void updateOnline(Online online) {
		String sql = "UPDATE `ONLINE` SET `USERNAME`=?, `PAGE`=?, `IP`=? WHERE `SSID`=?";
		super.update(sql,online.getUsername(),
				online.getPage(),online.getIp(),online.getSsid());
	}

	@Override
	public void deleteExpiresOnline(String ssid) {
		String sql = "DELETE FROM `ONLINE` WHERE `SSID`=?";
		super.update(sql, ssid);
	}

	@Override
	public Online getOnlineBySsid(String ssid) {
		String sql = "SELECT `SSID`,`USERNAME`,`PAGE`,`IP`,`TIME` FROM `ONLINE` WHERE `SSID`=?";
		return super.get(sql, ssid);
	}
	
}
