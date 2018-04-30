package com.naruto.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月30日
 *       自定义Filter
 */
public class FilterTest implements Filter {
	private String[] excludedURLArr;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("=======初始化过滤器=========");
		System.out.println("filterName：" + filterConfig.getFilterName());
		String excludedURL = filterConfig.getInitParameter("excludedURL");
		if (excludedURL != null) {
			excludedURLArr = excludedURL.split(",");
		} else {
			excludedURLArr = new String[0];
		}
		System.out.println("excludedURL:" + excludedURL);

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
		long start = System.currentTimeMillis();
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		boolean flag = false;
		for (String excludedURL : excludedURLArr) {
			if (url.endsWith(excludedURL)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("放行：" + url);
			filter.doFilter(request, response);
		} else {
			System.out.println("this is MyFilter,url :" + url);
			// 进行相关处理
			filter.doFilter(request, response);
			System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));
		}
	}

	@Override
	public void destroy() {
	}

}
