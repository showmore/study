package cn.joyair.mvcproject.lisener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ��Sessionʵ�������û�ͳ�ƣ������û�����Sessoin�Ĵ���������(����session��ʱ����)�� ���Ǻ�׼ȷ
 * @author caozhi
 *
 */

//@WebListener
public class OnlineListener implements HttpSessionListener,HttpSessionAttributeListener {

	@SuppressWarnings("unchecked")
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		Map<String, String> online =  (Map<String, String>) application.getAttribute("online");
		if(online==null) {
			online = new HashMap<>();
		}
		online.put(session.getId(), session.getAttribute("user").toString());
		application.setAttribute("online", online);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		Map<String, String> online =  (Map<String, String>) application.getAttribute("online");
		if(online==null) {
			online = new HashMap<>();
		}
		
		String username = (String) session.getAttribute("user");
		username = username == null?"�ο�":username;
		
		online.put(session.getId(), username);
		application.setAttribute("online", online);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		Map<String, String> online =  (Map<String, String>) application.getAttribute("online");
		if(online!=null) {
			online.remove(session.getId());
			application.setAttribute("online", online);
		}
		
	}

}
