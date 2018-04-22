package com.naruto.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月22日
 */

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@RequestMapping("/hello")
	public String hello(Map<String, Object> map) {
		map.put("msg", "hello thymeleaf");
		return "hello";
	}

}
