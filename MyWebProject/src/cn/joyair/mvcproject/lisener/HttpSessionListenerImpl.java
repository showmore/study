package cn.joyair.mvcproject.lisener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener,HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionListener�����������ʱ������"+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionListener���������Ƴ�ʱ������"+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionListener���������滻ʱ������"+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("ServletRequest��session����ʱ������");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("ServletRequest��session����ʱ������");
		
	}

}
