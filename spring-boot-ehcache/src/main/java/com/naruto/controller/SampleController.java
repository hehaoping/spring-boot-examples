package com.naruto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naruto.service.EhcacheDemoService;

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

	@Autowired
	private EhcacheDemoService ehCacheService;

	@RequestMapping("/ehcache/save")
	public String save(@RequestParam(defaultValue = "1", required = false) long id) {
		String save = ehCacheService.save(id);
		return save;
	}

	@RequestMapping("/ehcache/update")
	public String update(@RequestParam(defaultValue = "1", required = false) long id) {
		String update = ehCacheService.update(id);
		return update;
	}

	@RequestMapping("/ehcache/get")
	public String get(@RequestParam(defaultValue = "1", required = false) long id) {
		String data = ehCacheService.getById(id);
		return data;
	}

	@RequestMapping("/ehcache/delete")
	public String delete(@RequestParam(defaultValue = "1", required = false) long id) {
		ehCacheService.delete(id);
		return "delete ok";
	}

}
