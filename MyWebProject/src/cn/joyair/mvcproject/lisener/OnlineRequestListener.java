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
 * ����˼·��
 * 1.�����������ʱ�򣬼�¼�����ߵ���Ϣ���жϷ����ߣ���������ݿ��д�������û������·���ʱ�䣻���û���򴴽�������Ϣ�����ݿ�
 * 2.��¼�����û���ʱ�򣬼�¼���ʽ�����ʱ�䣬10���ӣ�����û�10���Ӷ�û�������������Ϊ�û����ߡ����ݿ������߼�¼ɾ����
 * 	 ServletContextListener,webӦ��������ʱ��Ҫ��ÿ5���飬�����û�������ִ��ɾ����
 * 3.�����ߵ�¼�ɹ��󣬽�online���ݱ����username,���ο͸�Ϊ�����û���
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
		// 1.ͨ�������õ������ߵĻ�����Ϣ
		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		HttpSession session = request.getSession();
		//��ȡsessionid
		String ssid = session.getId();
		//��ȡ������ip��ַ
		String ip = request.getRemoteAddr();
		//��ȡ����ҳ��
		String page = request.getRequestURI();
		//��ȡ�û���
		String username = (String) session.getAttribute("user");
		username = username==null?"�ο�":username;
		
		//�������ݿ�֮ǰ������Щ��Ϣ��װ��һ��Online������
		Online ol = new Online();
		ol.setSsid(ssid);
		ol.setPage(page);
		ol.setIp(ip);
		ol.setUsername(username);
		ol.setTime(new Date());
		
		
		//�������ݿ⣬����Ϣ�ŵ����ݿ⡣ �У�����time�� û�У������¼�¼��
		//1.����ssid����ѯ���ݿ⣬��û�м�¼
		Online online = onlineService.getOnlineBySsid(ssid);
		if(online!=null) {
			online.setTime(new Date());
			onlineService.updateOnline(online);
		}else {
			onlineService.insertOinline(online);
		}
		
	}

}