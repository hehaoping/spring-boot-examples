package com.naruto.controller;

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
		return "hello spring boot";
	}

}
