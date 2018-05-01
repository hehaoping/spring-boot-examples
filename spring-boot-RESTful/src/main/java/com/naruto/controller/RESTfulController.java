package com.naruto.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月1日
 */

@RestController
public class RESTfulController {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUserList(@RequestParam(required = false, defaultValue = "20") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int pageIndex) {
		// 通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		return "get请求,返回用户列表,分页,pageSize:" + pageSize + " pageIndex:" + pageIndex;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable Long id) {
		// url中的id可通过@PathVariable绑定到函数的参数中
		return "get请求 ,返回用户：" + id;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String postUser(@RequestParam Map<String, Object> map) {
		// 除了@RequestParam从页面中传递参数之外，还可以通过@ModelAttribute绑定参数
		System.out.println(map);
		return "post请求,创建一个用户";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id) {
		return "put请求，更新用户：" + id;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public String delUser(@PathVariable Long id) {
		return "delete请求，删除用户：" + id;
	}

	@RequestMapping(value = "getOrPost", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrPost() {
		return "get 或者 post 请求";
	}

}
