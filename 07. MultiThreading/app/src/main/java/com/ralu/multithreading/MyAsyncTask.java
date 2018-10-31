package com.ralu.multithreading;

import android.os.AsyncTask;
import android.os.TestLooperManager;
import android.util.Log;
import android.widget.TextView;

public class MyAsyncTask  extends AsyncTask <String, Integer, String> {

    private static final String TAG = "ASYNCTASK";

    private TextView tvMain;

    public MyAsyncTask(TextView tvMain){ this.tvMain = tvMain;}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvMain.setText("Task starting");
        Log.d(TAG, "on preExecute: Thread " + Thread.currentThread().getName());
    }


    @Override
    protected String doInBackground(String... strings) {

        Log.d(TAG, "doInBackground: " + strings[0]);
        Log.d(TAG, "doInBackground: Thread: " + Thread.currentThread().getName());
        publishProgress(1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Task completed";

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "in onProgressUpdate: Thread " + Thread.currentThread().getName());
        tvMain.setText("Task in progress");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "in onPostExecute : Thread "+ Thread.currentThread().getName());
        tvMain.setText(s);
    }
}
