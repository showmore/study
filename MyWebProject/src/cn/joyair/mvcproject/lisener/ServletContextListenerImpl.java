package cn.joyair.mvcproject.lisener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("�������������ر��ˡ�����������");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("�����������������ˡ�����������");
		ServletContext sc =event.getServletContext();
		System.out.println("�������õ��˴�������webӦ�õĶ������ã�"+sc.getServletContextName());
		
	}

}
