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
		System.out.println("HttpSessionListener域里属性添加时触发："+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionListener域里属性移除时触发："+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionListener域里属性替换时触发："+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("ServletRequest域session创建时触发：");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("ServletRequest域session销毁时触发：");
		
	}

}
