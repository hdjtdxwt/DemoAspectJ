package com.epsit.demoaspectj.aspectj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/4/3/003.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface LogRunningTime {

}
