package com.luochen.financial.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author luochenfx
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
	@Pointcut("execution(* com.luochen..*.*(..))")
	public void logPointcut() {
	}

	@Pointcut("within(@org.springframework.stereotype.Repository *)" +
			" || within(@org.springframework.stereotype.Service *)" +
			" || within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {
		// Method is empty as this is just a Pointcut, the implementations are in the advices.
	}

	@Around("logPointcut()")
	public Object timeConsumingRecord(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("切入点: " + joinPoint + "\t");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			long end = System.currentTimeMillis();
			log.info(" " + joinPoint + "\t 耗时 : " + (end - start) + " ms! \n" + "返回结果:" + result);
			return result;
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			log.error(" " + joinPoint + "\t 耗时 : " + (end - start) + " ms  -- 异常 : " + e.getMessage() , e);
			throw e;
		}
	}
}
