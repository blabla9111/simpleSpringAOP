package com.example.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ChangingArgsAspect {

    Logger logger = LoggerFactory.getLogger(ChangingArgsAspect.class.getName());

    @Pointcut("@annotation(ChangingArgs)")
    private void changingArgs(){}

    @Pointcut("execution(* com.example.springaop.service.impl.EmployeeServiceImpl.getMainEmployee(String))")
    private void changeIdForMainEmployee(){}

    @Around("changingArgs() && changeIdForMainEmployee()")
    public Object changeMainEmployee(ProceedingJoinPoint joinPoint) throws Throwable {
        Integer id = 0;
        String arg = (String) joinPoint.getArgs()[0];
        try {
            id = Integer.parseInt(arg);
            Integer newId = id / 2;
            arg = newId.toString();
        }
        catch (Throwable e){
            // ошибка выброситься в joinPoint.proceed
        }

        logger.info("changing id = " + id+" to id = "+arg);
        return joinPoint.proceed(new Object[]{arg});

    }

}
