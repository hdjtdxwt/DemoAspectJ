package com.epsit.demoaspectj.aspectj;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/3/003.
 */

public class AspectJThreadPool {
    private static AspectJThreadPool instance;

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE = 1;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(128);
    public static final Executor poolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS, sPoolWorkQueue);

    private AspectJThreadPool(){

    }

    public static AspectJThreadPool getInstance() {
        if(instance==null){
            synchronized (AspectJThreadPool.class){
                if(instance==null){
                    instance = new AspectJThreadPool();
                }
            }
        }
        return instance;
    }
    public void execute(Runnable runnable){
        poolExecutor.execute(runnable);
    }
}
