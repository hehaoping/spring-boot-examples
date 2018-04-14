package com.naruto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naruto.dao.SchoolMapper;
import com.naruto.entity.SchoolEntity;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月5日
 */
@RestController
public class SampleController {

	@Autowired
	private SchoolMapper schoolMapper;

	@RequestMapping("/helloDruid")
	public String hello() {
		List<SchoolEntity> all = schoolMapper.getAll();
		System.out.println(all.toString());
		return "hello spring boot druid";
	}

}
