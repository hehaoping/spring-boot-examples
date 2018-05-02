package com.naruto.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月1日
 */
@Api(tags = "RESTful接口文档示例")
@RestController
public class RESTfulController {

	@ApiOperation(value = "获取用户列表", notes = "传入分页参数可分页，默认每页20条数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页显示数(默认20)", required = false, dataType = "int"),
			@ApiImplicitParam(name = "pageIndex", paramType = "query", value = "第几页(默认1)", required = false, dataType = "int") })
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUserList(@RequestParam(required = false, defaultValue = "20") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int pageIndex) {
		// 通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		return "get请求,返回用户列表,分页,pageSize:" + pageSize + " pageIndex:" + pageIndex;
	}

	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", paramType = "path", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable Long id) {
		// url中的id可通过@PathVariable绑定到函数的参数中
		return "get请求 ,返回用户：" + id;
	}

	@ApiOperation(value = "创建用户", notes = "根据map键值对创建用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", paramType = "form", value = "姓名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "age", paramType = "form", value = "年龄", required = false, dataType = "int") })
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String postUser(@RequestParam @ApiIgnore Map<String, Object> map) {
		// 除了@RequestParam从页面中传递参数之外，还可以通过@ModelAttribute绑定参数
		System.out.println(map);
		return "post请求,创建一个用户";
	}

	@ApiOperation(value = "更新用户", notes = "根据url的id来更新用户详细信息")
	@ApiImplicitParam(name = "id", paramType = "path", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id) {
		return "put请求，更新用户：" + id;
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来删除指定用户")
	@ApiImplicitParam(name = "id", paramType = "path", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public String delUser(@PathVariable Long id) {
		return "delete请求，删除用户：" + id;
	}

	@ApiOperation(value = "测试get或者post方法")
	@RequestMapping(value = "getOrPost", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrPost() {
		return "get 或者 post 请求";
	}

}
