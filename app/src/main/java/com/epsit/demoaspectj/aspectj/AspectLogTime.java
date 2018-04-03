package com.epsit.demoaspectj.aspectj;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2018/4/3/003.
 * 仅仅是用来记录方法执行时间的，所以没有放到子线程
 */
@Aspect
public class AspectLogTime {
    String TAG ="AspectLogTime";
    //切入点
    @Pointcut("execution(@com.epsit.demoaspectj.aspectj.annotation.LogRunningTime * *())") //切入点是带有这个注解的所有方法
    public void calcuteTime(){

    }
    @Around("calcuteTime()")
    //切入方式
    public Object doCalcute(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        Log.e(TAG,"costTime="+(endTime-startTime));
        return object;
    }
}
