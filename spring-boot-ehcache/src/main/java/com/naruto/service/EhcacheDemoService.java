package com.naruto.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月5日
 *       ehcache注解说明
 * @EnableCaching 开启缓存功能，放在配置类或启动类上
 * @CacheConfig 缓存配置，设置缓存名称
 * @Cacheable 执行方法前先查询缓存是否有数据。有则直接返回缓存数据；否则查询数据再将数据放入缓存
 * @CachePut 执行新增或更新方法后，将数据放入缓存中
 * @CacheEvict 清除缓存
 * @Caching 将多个缓存操作重新组合到一个方法中
 */

@CacheConfig(cacheNames = "myCache")
@Service
public class EhcacheDemoService {

	// @CachePut、@Cacheable、@CacheEvict 等注解常用属性 key value（即cacheNames）
	// key 指的是缓存的唯一标识，同时可以用 # 来引用参数。 例如 @CachePut(key = "'user_'+#user.UUID")这里的单引号不能少，否则会报错，被识别是一个对象
	// value 指的是 ehcache.xml 中的缓存策略空间 这里在类名使用了全局@CacheConfig注解 标明myCache策略，故不再单独设置@CachePut、@Cacheable、@CacheEvict 等注解的value（即cacheNames）属性
	@CachePut(key = "#id")
	public String save(long id) {
		System.out.println("保存 id=" + id + " 的数据");
		return id + "_addCache";
	}

	@CachePut(key = "#id")
	public String update(long id) {
		System.out.println("修改 id=" + id + " 的数据");
		return id + "_updateCache_" + System.currentTimeMillis();
	}

	@Cacheable(key = "#id")
	public String getById(long id) {
		System.out.println("获取 id=" + id + " 的数据");
		return id + "_get";
	}

	@CacheEvict(key = "#id")
	public void delete(long id) {
		System.out.println("删除 id=" + id + " 的数据");
	}

}
