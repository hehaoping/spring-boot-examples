package com.naruto.services;

import org.springframework.stereotype.Service;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月3日
 */
@Service
public class TestService {

	public void doSome(int i) {
		System.out.println("来自service：" + i);
	}

}
