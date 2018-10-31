package com.ralu.multithreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private TextView tvMain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding

        tvMain = findViewById(R.id.tvMain);
        handler = new Handler(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onMultithreading(View view) {

        switch (view.getId()){
            case R.id.btnThread:
                MyThread myThread = new MyThread(tvMain);
                myThread.start();
                break;

            case R.id.btnRunnable:
                MyRunnable myRunnable = new MyRunnable(handler);
                Thread thread = new Thread(myRunnable);
                thread.start();
                break;

            case R.id.btnAsyncTask:
                MyAsyncTask myAsyncTask = new MyAsyncTask(tvMain);
                myAsyncTask.execute("main");
                break;

            case R.id.btnEventBus:
                new Thread (()->{
                    Event event = new Event("This is the initial data");
                    EventBus.getDefault().post(event);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    event.setData("New Data");

                    EventBus.getDefault().post(event);
                }).start();
                break;
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        tvMain.setText(msg.getData().getString("data"));

        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventReceived (Event event){
        tvMain.setText(event.getData());
    }
}
