package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DELAY_MS = 9000;
    private Handler handler;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView logoImageView = findViewById(R.id.logo_id);
        RelativeLayout splash = findViewById(R.id.splashLayout); // Dapatkan referensi ke layout root

        // Membuat animasi fade-in
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        logoImageView.startAnimation(fadeInAnimation);

        // Kodingan untuk membuat animasi background-nya bergerak
        animationDrawable = (AnimationDrawable) splash.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(3000);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Memulai MainActivity dengan efek transisi
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_left);
                finish();
            }
        }, SPLASH_DELAY_MS);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            animationDrawable.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }
}