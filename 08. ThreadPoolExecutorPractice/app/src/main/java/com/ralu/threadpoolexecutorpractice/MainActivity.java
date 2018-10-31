package com.ralu.threadpoolexecutorpractice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar1, progressBar2, progressBar3, progressBar4;
    private TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addCallable(View view) {
    }

    public static class UIHandler extends Handler {
        private WeakReference<TextView> tvFirstThread, tvSecondThread, tvThirdThread, tvFourthThread;
        private WeakReference<ProgressBar> firstProgress, secondProgress, thirdProgress, fourthProgress;

        public UIHandler (Looper looper,
                          TextView tvFirstThread,
                          TextView tvSecondThread,
                          TextView tvThirdThread,
                          TextView tvFourthThread,
                          ProgressBar firstProgress,
                          ProgressBar secondProgress,
                          ProgressBar thirdProgress,
                          ProgressBar fourthProgress){

            super(looper);
            this.tvFirstThread = new WeakReference<>(tvFirstThread);
            this.tvSecondThread = new WeakReference<>(tvSecondThread);
            this.tvThirdThread = new WeakReference<>(tvThirdThread);
            this.tvFourthThread = new WeakReference<>(tvFourthThread);
            this.firstProgress = new WeakReference<>(firstProgress);
            this.secondProgress = new WeakReference<>(secondProgress);
            this.thirdProgress = new WeakReference<>(thirdProgress);
            this.fourthProgress = new WeakReference<>(fourthProgress);

        }

        @Override
        public void handleMessage(Message msg){
            switch(msg.what){
                case 1:
                    firstProgress.get().setProgress(msg.getData().getInt("int"));
                    tvFirstThread.get().setText(msg.getData().getString("message"));
                    break;
                case 2:
                    secondProgress.get().setProgress(msg.getData().getInt("int"));
                    tvSecondThread.get().setText(msg.getData().getString("message"));
                    break;
                case 3:
                    thirdProgress.get().setProgress(msg.getData().getInt("int"));
                    tvThirdThread.get().setText(msg.getData().getString("message"));
                    break;
                case 4:
                    fourthProgress.get().setProgress(msg.getData().getInt("int"));
                    tvFourthThread.get().setText(msg.getData().getString("message"));
                    break;
            }

        }
    }
}
