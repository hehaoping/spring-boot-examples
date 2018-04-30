package com.naruto.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.naruto.servlet.ServletTest;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月30日
 */
@Configuration
public class WebConfiguration {

	/**
	 * 注册一个servlet
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean registServletBean() {
		return new ServletRegistrationBean(new ServletTest(), "/servletTest");
	}

}
