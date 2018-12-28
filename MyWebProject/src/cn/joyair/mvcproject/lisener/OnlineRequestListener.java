package cn.joyair.mvcproject.lisener;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.joyair.mvcproject.model.Online;
import cn.joyair.mvcproject.service.FactoryService;
import cn.joyair.mvcproject.service.OnlineService;
/**
 * 基本思路：
 * 1.当请求进来的时候，记录访问者的信息，判断访问者，如果在数据库中存在这个用户，更新访问时间；如果没有则创建访问信息到数据库
 * 2.记录在线用户的时候，记录访问进来的时间，10分钟，如果用户10分钟都没有请求操作，认为用户离线。数据库中在线记录删除。
 * 	 ServletContextListener,web应用启动的时候，要做每5秒检查，过期用户，并且执行删除。
 * 3.访问者登录成功后，将online数据表里的username,从游客改为真正用户名
 *
 */
@WebListener
public class OnlineRequestListener implements ServletRequestListener {
	
	OnlineService onlineService = FactoryService.getOnlineService();

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		// 1.通过请求拿到访问者的基本信息
		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		HttpSession session = request.getSession();
		//获取sessionid
		String ssid = session.getId();
		//获取访问者ip地址
		String ip = request.getRemoteAddr();
		//获取访问页面
		String page = request.getRequestURI();
		//获取用户名
		String username = (String) session.getAttribute("user");
		username = username==null?"游客":username;
		
		//操作数据库之前，把这些信息封装在一个Online对象中
		Online ol = new Online();
		ol.setSsid(ssid);
		ol.setPage(page);
		ol.setIp(ip);
		ol.setUsername(username);
		ol.setTime(new Date());
		
		
		//链接数据库，把信息放到数据库。 有：更新time， 没有：插入新纪录。
		//1.根据ssid，查询数据库，有没有记录
		Online online = onlineService.getOnlineBySsid(ssid);
		if(online!=null) {
			online.setTime(new Date());
			onlineService.updateOnline(online);
		}else {
			onlineService.insertOinline(online);
		}
		
	}

}
