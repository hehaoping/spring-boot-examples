package com.naruto.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.github.pagehelper.Page;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月6日
 */
@Mapper
public interface BaseMapper {

	public static final String SQLFIELD = "sqlField";

	@SelectProvider(type = BaseSqlProvider.class, method = "getSQL")
	public List<Map<String, Object>> fetch(Map<String, Object> paramMap);

	@SelectProvider(type = BaseSqlProvider.class, method = "getSQL")
	public Page<Map<String, Object>> fetchPage(Map<String, Object> paramMap);

	@SelectProvider(type = BaseSqlProvider.class, method = "getSQL")
	public String executeString(Map<String, Object> paramMap);

	@SelectProvider(type = BaseSqlProvider.class, method = "getSQL")
	public long executeLong(Map<String, Object> paramMap);

	class BaseSqlProvider {
		public String getSQL(Map<String, Object> paramMap) {
			return paramMap.get(SQLFIELD).toString();
		}
	}

}
