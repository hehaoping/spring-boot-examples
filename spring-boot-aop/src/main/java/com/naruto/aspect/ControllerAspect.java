package com.naruto.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月12日
 */
@Aspect
@Component
public class ControllerAspect {

	/**
	 * 定义切入点规则
	 */
	@Pointcut("execution(* com.naruto.controller.SampleController.*(..))")
	public void methodPointCut() {
	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void annotationPointCut() {

	}

	// 使用环绕通知 切入点具体实现。注解内也可直接写上Pointcut上的切入点规则
	@Around("methodPointCut()&&annotationPointCut()")
	public Object method(ProceedingJoinPoint pjp) {
		System.out.println("------Aspect处理------");
		long start = System.currentTimeMillis();

		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("参数为:" + arg);
			if (arg != null && !arg.toString().equals("admin")) {
				return "没有权限";
			}
		}
		Object object = null;
		try {
			object = pjp.proceed();
			System.out.println("proceed:" + object);
			if (object instanceof String) {
				object = "aop spring boot";
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));
		return object;
	}

}
