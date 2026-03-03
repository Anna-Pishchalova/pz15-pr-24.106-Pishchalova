package com.example.pz15;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_screen  extends AppCompatActivity {
    private static final long display = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(Splash_screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, display);
    }
    public void run() {
        Intent intent = new Intent(Splash_screen.this, Onboarding.class);
        startActivity(intent);
        finish();
    }
}
