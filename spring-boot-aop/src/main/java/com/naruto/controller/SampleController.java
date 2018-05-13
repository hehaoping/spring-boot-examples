package com.naruto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月5日
 */
@RestController
public class SampleController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello spring boot aop");
		return "spring boot aop";
	}

	@RequestMapping("/getUserInfo")
	public String getUserInfo(String name, long id) {
		System.out.println("执行getUserInfo方法");
		return "get userInfo OK";
	}

	@GetMapping("/other")
	public String other() {
		return "other";
	}

}
