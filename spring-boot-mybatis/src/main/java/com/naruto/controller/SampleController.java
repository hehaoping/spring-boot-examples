package com.naruto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naruto.services.TestService;
import com.naruto.utility.TransactionUtil;

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
	private TransactionUtil tran;

	@Autowired
	private TestService service;

	@RequestMapping("/testTran")
	public String testTran() {
		boolean commit = tran.commit(f -> service.doSome(23));
		System.out.println(commit);
		return "spring boot transaction " + commit;
	}

}
