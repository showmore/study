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
	//�����߳������õ�ʱ��û�в���������
	public final int MAX_MILLTIS = 10*60*1000; //ʮ���ӣ����� ��
	
	
	OnlineService onlineService = FactoryService.getOnlineService();
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//��Ź�ʱ�ķ�����
		List<Online> expiresUserList = new ArrayList<>();
		
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		
		//������������ʱ��ͱ�ִ��
		//��ʱ��
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
				//�����ݿ���ɾ����������Ϣ
				onlineService.deleteExpiresOnline(expiresUserList);
				//���ݿ���ɾ���˹�ʱ�ķ�����,�������
				expiresUserList.clear();
			}
		}).start();
		
	}


	
}
