package com.example.pz15;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private Button btnSwitchLanguage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);
        btnSwitchLanguage = findViewById(R.id.switchlanguage);
        btnSwitchLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchLanguage();
            }
        });
    }

    private void switchLanguage() {
        String currentLanguage = LocaleHelper.getLanguage(this);

        String newLanguage;
        if (currentLanguage.equals("ru")) {
            newLanguage = "en";
            Toast.makeText(this, "Switching to English", Toast.LENGTH_SHORT).show();
        } else {
            newLanguage = "ru";
            Toast.makeText(this, "Переключаем на русский", Toast.LENGTH_SHORT).show();
        }
        LocaleHelper.setLocale(this, newLanguage);
        recreate();
    }
}