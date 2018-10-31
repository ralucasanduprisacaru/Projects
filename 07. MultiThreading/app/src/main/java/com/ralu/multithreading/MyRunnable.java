package com.ralu.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MyRunnable implements Runnable {
    private Handler handler;

    public MyRunnable(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", "Task starting");
        message.setData(bundle);

        // Before the task starts
        handler.sendMessage(message);

        // Task executing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After the task completes

        Message message1 = new Message();
        bundle.putString("data", "Task completed");
        message.setData(bundle);
        handler.sendMessage(message1);

    }
}
