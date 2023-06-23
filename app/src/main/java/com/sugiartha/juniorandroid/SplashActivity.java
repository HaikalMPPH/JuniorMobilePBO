package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DELAY_MS = 3000;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logoImageView = findViewById(R.id.logo_id);

        // Membuat animasi fade-in
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        logoImageView.startAnimation(fadeInAnimation);

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
}