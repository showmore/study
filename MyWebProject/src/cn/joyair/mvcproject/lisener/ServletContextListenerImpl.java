package cn.joyair.mvcproject.lisener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("监听到服务器关闭了。。。。。。");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("监听到服务器启动了。。。。。。");
		ServletContext sc =event.getServletContext();
		System.out.println("监听器拿到了代表整个web应用的对象引用："+sc.getServletContextName());
		
	}

}
