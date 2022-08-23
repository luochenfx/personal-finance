package com.luochen.financial.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

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
        StopWatch stopWatch = new StopWatch(joinPoint.getSignature().getDeclaringTypeName());
        stopWatch.start(joinPoint.getSignature().getName());
        try {
            Object result = joinPoint.proceed();
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
            return result;
        } catch (Throwable e) {
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
            throw e;
        }
    }
}
