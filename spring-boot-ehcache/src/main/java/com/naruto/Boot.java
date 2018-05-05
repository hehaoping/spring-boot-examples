package com.naruto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月5日
 */
@EnableCaching // 开启缓存功能
@SpringBootApplication
public class Boot extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

}
