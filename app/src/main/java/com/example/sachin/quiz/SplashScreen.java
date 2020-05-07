package com.example.sachin.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends Activity {
    private static int SLPASH_TIME_OUT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(splash);
                finish();
            }
        },SLPASH_TIME_OUT);
    }
}
