package cn.joyair.mvcproject.lisener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.swing.Timer;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import cn.joyair.mvcproject.model.Online;
import cn.joyair.mvcproject.service.FactoryService;
import cn.joyair.mvcproject.service.OnlineService;


@WebListener
public class OnlineServletContextLinstener implements ServletContextListener {
	//访问者超过设置的时间没有操作，离线
	public final int MAX_MILLTIS = 10*60*1000; //十分钟（毫秒 ）
	
	
	OnlineService onlineService = FactoryService.getOnlineService();
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//存放过时的访问者
		List<Online> expiresUserList = new ArrayList<>();
		
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		
		//服务器启动的时候就被执行
		//定时器
		new Timer(5*1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				List<Online> list = onlineService.getAllonline();
				if(list!=null && list.size()>0) {
					Date exDate = null;
					for(Online ol:list) {
						exDate = ol.getTime();
						sdf.format(exDate);
						Long exMilles;
						try{
							exMilles = sdf.parse(exDate.toString()).getTime();
							if((System.currentTimeMillis() - exMilles) > MAX_MILLTIS) {
								expiresUserList.add(ol);
							}
						} catch(ParseException | java.text.ParseException e) {
							e.printStackTrace();
						}

					}
				}
				//从数据库中删除访问者信息
				onlineService.deleteExpiresOnline(expiresUserList);
				//数据库中删除了过时的访问者,清除集合
				expiresUserList.clear();
			}
		}).start();
		
	}


	
}
