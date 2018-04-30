package com.naruto.repository;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.naruto.entity.School;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月15日
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolRepositoryTest {

	@Autowired
	private SchoolRepository schoolRepository;

	@Test
	public void testAdd() {
		School s = new School();
		s.setId(5);
		s.setName("xxx小学");
		s.setAdduser("admin");
		s.setAddtime(new Date());
		School result = schoolRepository.save(s);
		System.out.println(result);
	}

	@Test
	public void testFindOne() {
		School result = schoolRepository.findOne(4L);
		System.out.println(result);
	}

	@Test
	public void testFindAll() {
		List<School> list = schoolRepository.findAll();
		System.out.println(list);
	}

	@Test
	public void testPage() {
		// page 是从0开始
		Pageable pageable = new PageRequest(0, 2);
		Page<School> result = schoolRepository.findAll(pageable);
		System.out.println("total:" + result.getTotalElements() + " pages:" + result.getTotalPages());
		System.out.println(result.getContent());
	}

	@Test
	public void testUpdate() {
		School s = schoolRepository.findOne(5L);// 需要load一个对象出来
		// 只更新设置字段 需要配置该注解@DynamicUpdate
		s.setCode("code123");
		s.setModifyuser("modify");
		s.setModifytime(new Date());
		School result = schoolRepository.save(s);
		System.out.println(result);
	}

	@Test
	public void testdelete() {
		schoolRepository.delete(5L);
	}

}
