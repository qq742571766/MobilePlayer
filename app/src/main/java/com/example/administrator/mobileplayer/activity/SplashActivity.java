package com.example.administrator.mobileplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.administrator.mobileplayer.R;

import static android.content.ContentValues.TAG;

public class SplashActivity extends Activity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "run:" + Thread.currentThread().getName());
                startMianActivity();
            }
        }, 2000);
    }

    private boolean isstartMianActivity = false;

    private void startMianActivity() {
        if (!isstartMianActivity) {
            isstartMianActivity = true;
            Intent intent = new Intent(this, MianActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent:" + event.getAction());
        startMianActivity();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
