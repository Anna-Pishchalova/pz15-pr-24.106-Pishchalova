package com.example.pz15;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.provider.MediaStore;

public class MainActivity extends BaseActivity {

    private Button btnSwitchLanguage;
    private Button buttonCamera;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        btnSwitchLanguage = findViewById(R.id.switchlanguage);
        if (btnSwitchLanguage != null) {
            btnSwitchLanguage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchLanguage();
                }
            });
        }
        buttonCamera = findViewById(R.id.addphoto);
        if (buttonCamera != null) {
            buttonCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCamera();
                }
            });
        }
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

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}