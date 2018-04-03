package com.epsit.demoaspectj.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2018/4/3/003.
 */
@Aspect
public class NewThreadTaskExecute {
    //切入面
    @Pointcut("execution(@com.epsit.demoaspectj.aspectj.annotation.NewThreadTask void *())")
    public void doStart(){

    }
    //切入方式
    @Around("doStart()")
    public void newThreadExecute(final ProceedingJoinPoint joinPoint){
        Object obj ;
        AspectJThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }
}
