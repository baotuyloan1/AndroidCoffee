package com.example.appbanhang.Activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbanhang.Activity.LoginSignup.StartUpActivity;
import com.example.appbanhang.R;

public class SplashActivity extends AppCompatActivity {

    private Animation topAnim, bottomAnim;
    private TextView textViewName, textViewDiaChi;
    private int SPLASH_SCREEN = 3000;

    private SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_splash);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_splash);

        textViewName = (TextView) findViewById(R.id.txtSplashTen);
        textViewDiaChi = (TextView) findViewById(R.id.txtSplahDiaChi);

        textViewName.setAnimation(topAnim);
        textViewDiaChi.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);

                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                    Intent intent = new Intent(SplashActivity.this, OnBoardingActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, StartUpActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_SCREEN);
    }
}

