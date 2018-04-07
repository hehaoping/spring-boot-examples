package com.naruto.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月6日
 */
@Mapper
public interface BaseMapper {

	public static final String SQLFIELD = "sqlField";

	@SelectProvider(type = BaseSqlProvider.class, method = "fetch")
	public List<Map<String, Object>> fetch(Map<String, Object> paramMap);

	@SelectProvider(type = BaseSqlProvider.class, method = "executeString")
	public String executeString(Map<String, Object> paramMap);

	@SelectProvider(type = BaseSqlProvider.class, method = "executeLong")
	public long executeLong(Map<String, Object> paramMap);

	class BaseSqlProvider {
		public String fetch(Map<String, Object> paramMap) {
			return paramMap.get(SQLFIELD).toString();
		}

		public String executeString(Map<String, Object> paramMap) {
			return paramMap.get(SQLFIELD).toString();
		}

		public String executeLong(Map<String, Object> paramMap) {
			return paramMap.get(SQLFIELD).toString();
		}
	}

}
