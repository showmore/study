package cn.joyair.mvcproject.lisener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextAttributeListenerImpl implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("ServletContext域里添加了属性");
		System.out.println("新添加的属性名："+event.getName());
		System.out.println("新添加的属性值："+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("ServletContext域里移除了属性");
		System.out.println("被删除的属性名："+event.getName());
		System.out.println("被删除的属性值："+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("ServletContext域里的属性被替换");
		System.out.println("被替换的属性名："+event.getName());
		System.out.println("被替换的属性值："+event.getName());
	}

	


}
