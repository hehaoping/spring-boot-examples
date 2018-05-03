package com.naruto.utility;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月3日
 */
@Component
public class TransactionUtil {

	@Autowired
	private PlatformTransactionManager transactionManager;

	public boolean commit(Consumer<?> consumer) {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			consumer.accept(null);
			transactionManager.commit(status);
			return true;
		} catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			return false;
		}

	}

}
