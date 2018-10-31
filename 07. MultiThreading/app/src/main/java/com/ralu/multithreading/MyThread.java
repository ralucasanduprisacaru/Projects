package com.ralu.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;



public class MyThread  extends Thread{

    private TextView tvMain;
    private Handler handler;

    public MyThread(TextView tvMain) {
        this.tvMain = tvMain;
            this.handler = new Handler(Looper.getMainLooper());

    }

    @Override
    public void run() {
        super.run();

        //Before the task starts
        handler.post(()->{
            tvMain.setText("Task Starting");
        });

        // Task execution
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        // Task Completed
        handler.post(()-> {
            tvMain.setText("Task completed");
        });
    }
}
