package com.naruto.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.naruto.dao.SchoolCommonMapper;
import com.naruto.dao.SchoolMapper;
import com.naruto.entity.School;
import com.naruto.entity.SchoolEntity;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月6日
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolMapperTest {

	@Autowired
	private SchoolMapper schoolMapper;

	@Test
	public void testQuery() {
		List<SchoolEntity> all = schoolMapper.getAll();
		System.out.println(all.toString());
	}

	@Test
	public void testInsert() {
		for (int i = 4; i < 6; i++) {
			SchoolEntity school = new SchoolEntity(i, "学校" + i, null, "memo" + i, null, null, "system", new Date(), null, null);
			int res = schoolMapper.add(school);
			System.out.println("结果：" + res);
		}
	}

	@Test
	public void testDelete() {
		schoolMapper.delete(5);
	}

	@Test
	public void testUpdate() {
		SchoolEntity schoolEntity = new SchoolEntity();
		schoolEntity.setId(4);
		schoolEntity.setName("xxx大学");
		schoolMapper.update(schoolEntity);
	}

	@Test
	public void testfind() {
		List<Map<String, Object>> find = schoolMapper.findSchoolTeacher(1);
		for (Map<String, Object> map : find) {
			System.out.println(map.get("id") + ":" + map.get("name") + ":" + map.get("addTime") + " tid:" + map.get("tID") + "tname:"
					+ map.get("tname"));

		}
	}

	@Test
	public void testExecuteString() {
		String name = schoolMapper.executeString(2);
		System.out.println(name);

	}

	@Test
	public void testPageExecute() {
		PageHelper.startPage(2, 2);
		List<SchoolEntity> pageResult = schoolMapper.getAll();
		System.out.println(pageResult);
	}

	@Autowired
	private SchoolCommonMapper schoolCommonMapper;

	@Test
	public void testCommonMapperAdd() {
		School school = new School();
		school.setId(6);
		school.setName("sdfsdf");
		school.setAdduser("system");
		school.setAddtime(new Date());
		int insert = schoolCommonMapper.insert(school);
		System.out.println(insert);
	}

	@Test
	public void testCommonMapperDel() {
		School school = new School();
		school.setId(6);
		// int delete = schoolCommonMapper.delete(school);
		int delete = schoolCommonMapper.deleteByPrimaryKey(7L);
		System.out.println(delete);
	}

	@Test
	public void testCommonMapperUpdate() {
		School s = new School();
		s.setId(7);
		s.setCode("code");
		int update = schoolCommonMapper.updateByPrimaryKeySelective(s);// 根据主键 更新指定字段
		System.out.println(update);
	}

	@Test
	public void testCommonMapperSelect() {
		List<School> listAll = schoolCommonMapper.selectAll();
		System.out.println(listAll);

		School s = schoolCommonMapper.selectByPrimaryKey(2L);
		System.out.println(s);

		Example example = new Example(School.class);
		Criteria c = example.createCriteria();
		c.andLike("name", "%学%");
		c.andEqualTo("adduser", "admin");
		List<School> selectByExample = schoolCommonMapper.selectByExample(example);
		System.out.println(selectByExample);
	}

}
