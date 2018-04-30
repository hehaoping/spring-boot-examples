package com.naruto.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.naruto.dao.BaseMapper;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月6日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicMapperTest {

	@Autowired
	private BaseMapper basicMapper;

	@Test
	public void testFetch() {
		SQL s = new SQL();
		s.SELECT("name").FROM("school").WHERE("id>#{id}", "name like #{name} ");
		s.AND().WHERE("adduser=#{adduser}");
		String sql = s.toString();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BaseMapper.SQLFIELD, sql);
		paramMap.put("id", 1);
		paramMap.put("name", "%中学%");
		paramMap.put("adduser", "admin");
		List<Map<String, Object>> fetch = basicMapper.fetch(paramMap);
		System.out.println(fetch);

	}

	@Test
	public void testExecuteLong() {
		String sql = "select count(1) from school ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BaseMapper.SQLFIELD, sql);
		long count = basicMapper.executeLong(paramMap);
		System.out.println(count);

	}

	@Test
	public void testExecuteString() {
		SQL s = new SQL();
		s.SELECT("name").FROM("school").WHERE("id=#{id}");
		String sql = s.toString();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BaseMapper.SQLFIELD, sql);
		paramMap.put("id", 2);
		String name = basicMapper.executeString(paramMap);
		System.out.println(name);

	}

	@Test
	public void testPageFetch() {
		SQL s = new SQL();
		s.SELECT("*").FROM("school");
		String sql = s.toString();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BaseMapper.SQLFIELD, sql);
		PageHelper.startPage(1, 2);// 从第一页开始，每页2条数据
		Page<Map<String, Object>> pageResult = basicMapper.fetchPage(paramMap);
		System.out.println("Total----" + pageResult.getTotal());
		for (Map<String, Object> map : pageResult) {
			System.out.println(map);
		}
	}

	@Test
	public void testUpdate() {
		String sql = "update  school set name=#{name} where id=#{id} ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BaseMapper.SQLFIELD, sql);
		paramMap.put("id", 5);
		paramMap.put("name", "cs小学");
		long updateCount = basicMapper.executeUpdate(paramMap);
		System.out.println(updateCount);
	}

	@Test
	public void testDelete() {
		String sql = "delete from  school where id=#{id} ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BaseMapper.SQLFIELD, sql);
		paramMap.put("id", 5);
		long deleteCount = basicMapper.executeDelete(paramMap);
		System.out.println(deleteCount);
	}

}
