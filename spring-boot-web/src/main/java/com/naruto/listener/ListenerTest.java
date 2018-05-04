package com.naruto.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月4日
 *       1、不同功能的Listener 需要实现不同的 Listener 接口，一个Listener也可以实现多个接口，这样就可以多种功能的监听器一起工作。
 *       2、8种监听器可以分为三类：
 *       1）监听 Session、request、context 的创建于销毁，分别为
 *       HttpSessionLister、ServletContextListener、ServletRequestListener
 *       2）监听对象属性变化，分别为：
 *       HttpSessionAttributeLister、ServletContextAttributeListener、ServletRequestAttributeListener
 *       3）监听Session 内的对象，分别为HttpSessionBindingListener 和 HttpSessionActivationListener。与上面六类不同，这两类 Listener 监听的是Session 内的对象，而非 Session
 *       本身，不需要在 web.xml中配置。
 */
public class ListenerTest implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("初始化监听器.......");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
