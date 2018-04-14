package com.naruto.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import com.naruto.entity.SchoolEntity;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月5日
 */
@Mapper
public interface SchoolMapper {

	@Select("select * from school")
	public List<SchoolEntity> getAll();

	@Insert("insert into school (id,name,code,memo,prop1,prop2,adduser,addtime,modifyuser,modifytime) values ( #{id},#{name},#{code},#{memo},#{prop1},#{prop2},#{adduser},#{addtime},#{modifyuser},#{modifytime} ) ")
	public int add(SchoolEntity school);

	@Delete("delete from school where id=#{id}")
	public int delete(long id);

	@Update("update school set name=#{name} where id=#{id}")
	public int update(SchoolEntity school);

	@Select("select s.id,s.name,t.id as tID,t.name as tname, s.addTime from school s,teacher t where s.id=t.schoolID and s.id=#{schoolID} ")
	public List<Map<String, Object>> findSchoolTeacher(long schoolID);

	// 动态sql查询

	@SelectProvider(type = SchoolSqlProvider.class, method = "executeString")
	public String executeString(int id);

	// 方便测试用内部类
	class SchoolSqlProvider {
		public String executeString() {
			SQL s = new SQL();
			s.SELECT("name").FROM("school").WHERE("id=#{id}");
			String sql = s.toString();
			return sql;
		}
	}

}
