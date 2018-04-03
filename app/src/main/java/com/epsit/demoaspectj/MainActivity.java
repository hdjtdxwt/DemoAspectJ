package com.epsit.demoaspectj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.epsit.demoaspectj.aspectj.annotation.LogRunningTime;
import com.epsit.demoaspectj.aspectj.annotation.NewThreadTask;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick1(View view){
        Log.e(TAG,"---onClick1");
        uploadFile();
    }


    public void onClick2(View view){
        Log.e(TAG,"---onClick1");
        downloadImage();
    }

    @NewThreadTask
    private void uploadFile() {
        Log.e(TAG,"耗时操作-->uploadFile-->"+Thread.currentThread().getName());
    }
    @NewThreadTask
    private void downloadImage() {
        Log.e(TAG,"耗时操作-->downloadImage"+Thread.currentThread().getName());
    }
}
