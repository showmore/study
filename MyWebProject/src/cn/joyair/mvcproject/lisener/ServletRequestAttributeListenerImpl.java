package cn.joyair.mvcproject.lisener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestAttributeListenerImpl implements ServletRequestListener,ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequest�����������ʱ������"+event.getName()+";"+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequest���������Ƴ�ʱ������"+event.getName()+";"+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequest���������滻ʱ������"+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("ServletRequest�������ʱ������"+event.getServletRequest());
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("ServletRequest������ʼ��ʱ������"+event.getServletRequest());
	}
	
	

}
