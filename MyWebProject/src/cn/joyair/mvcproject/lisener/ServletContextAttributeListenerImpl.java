package cn.joyair.mvcproject.lisener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextAttributeListenerImpl implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("ServletContext�������������");
		System.out.println("����ӵ���������"+event.getName());
		System.out.println("����ӵ�����ֵ��"+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("ServletContext�����Ƴ�������");
		System.out.println("��ɾ������������"+event.getName());
		System.out.println("��ɾ��������ֵ��"+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("ServletContext��������Ա��滻");
		System.out.println("���滻����������"+event.getName());
		System.out.println("���滻������ֵ��"+event.getName());
	}

	


}
