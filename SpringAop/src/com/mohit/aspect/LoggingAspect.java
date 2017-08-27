package com.mohit.aspect;


import com.mohit.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

//     to run specific class getName we need to put full package reference wtih com..getName
//     @Before("execution(public String getName())") for all getters use wildcard * and can use && after 1 execution
//     @Pointcut(whithin(packagePathToClass)) if we want for class level
//     @After and @AfterReturning returning one for successfull execution of method  and throwing after throwing error

//    @Before("allGetters() && allCircle()")
//    public void LoggingAdvice(){
//        System.out.println("1st Advice run. Get method called");
//    }

//    @Before("allGetters()")
//    public void second(){
//        System.out.println("2nd Advice run. Get method called");
//    }

    @Before("allCircle()")
    public void LoggingAdvice(JoinPoint joinPoint){
//        System.out.println(joinPoint.getTarget().toString());
//        Circle obj=(Circle) joinPoint.getTarget();

    }



    @Pointcut("execution(public * get*())")
    public void allGetters(){}

    @Pointcut("within(com.mohit.model.Circle)")
    public void allCircle(){}

    @Around("allGetters()")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){

        Object returnValue=null;
        try {
            System.out.println("Before Running process");
            returnValue=proceedingJoinPoint.proceed();
            System.out.println("After Running process");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("Finally");
        }
        return returnValue;
    }
}
