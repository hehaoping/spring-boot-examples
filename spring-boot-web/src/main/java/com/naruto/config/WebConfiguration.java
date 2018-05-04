package com.naruto.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.naruto.filter.FilterTest;
import com.naruto.listener.ListenerTest;
import com.naruto.servlet.ServletTest;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月30日
 */
@Configuration
public class WebConfiguration {

	/**
	 * 注册一个Servlet
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean registServletBean() {
		return new ServletRegistrationBean(new ServletTest(), "/servletTest");
	}

	/**
	 * 注册一个Filter
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean registFilterBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		FilterTest filterTest = new FilterTest();
		bean.setFilter(filterTest);
		List<String> urls = new ArrayList<String>();
		urls.add("/*");// 过滤所有请求
		bean.setUrlPatterns(urls);
		bean.setName("com.naruto.filter.FilterTest");// 可不用设置名
		Map<String, String> initParameters = new HashMap<>();
		initParameters.put("excludedURL", ".js,.css,.jpg,.png");// 排除js、css、图片等资源
		bean.setInitParameters(initParameters);
		return bean;
	}

	@Bean
	public ServletListenerRegistrationBean<ListenerTest> registServletListenerBean() {
		return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
	}

}
