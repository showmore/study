package cn.joyair.mvcproject.lisener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestAttributeListenerImpl implements ServletRequestListener,ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequest域里属性添加时触发："+event.getName()+";"+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequest域里属性移除时触发："+event.getName()+";"+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequest域里属性替换时触发："+event.getName()+";"+event.getValue());
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("ServletRequest请求结束时触发："+event.getServletRequest());
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("ServletRequest域请求始化时触发："+event.getServletRequest());
	}
	
	

}
