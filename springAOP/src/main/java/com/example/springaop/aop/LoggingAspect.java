package com.example.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Pointcut("@annotation(MyLogger)")
    private void loggingBeforeCallMethod(){}

    @Before("loggingBeforeCallMethod()")
    public void infoAboutCallingMethods(JoinPoint joinPoint){
        logger.info("Call method: "+joinPoint.toShortString());
    }

    @AfterReturning(pointcut = "loggingBeforeCallMethod()",
    returning = "result")
    public void infoSuccessfulExecMethod(JoinPoint joinPoint, Object result){
        logger.info("The method is returned -> "+result.toString());
    }

    @AfterThrowing(pointcut = "loggingBeforeCallMethod()",
    throwing = "exception")
    public void infoThrowingExceptionFromMethod(JoinPoint joinPoint, Throwable exception){
        logger.info("The method is thrown an exception -> "+exception.toString());
    }

    @After("loggingBeforeCallMethod()")
    public void infoMethodExec(JoinPoint joinPoint){
        logger.info("End of method  "+joinPoint.toString());
    }

}
