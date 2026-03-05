package com.example.pz15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class FeelingsActivity extends AppCompatActivity {

    private ImageButton imageCalm, imageRelaxed, imageEnergetic, imageSad;
    private String selectedFeeling = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();
        setupClickListeners();
    }

    private void initViews() {
        imageCalm = findViewById(R.id.calm);
        imageRelaxed = findViewById(R.id.relax);
        imageEnergetic = findViewById(R.id.energetic);
        imageSad = findViewById(R.id.sad);
    }

    private void setupClickListeners() {
        imageCalm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFeeling(0, "Спокойный");
            }
        });

        imageRelaxed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFeeling(1, "Расслабленный");
            }
        });

        imageEnergetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFeeling(2, "Энергичный");
            }
        });

        imageSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFeeling(3, "Грустный");
            }
        });
    }

    private void selectFeeling(int position, String feelingName) {
        Toast.makeText(this, "Выбрано: " + feelingName, Toast.LENGTH_SHORT).show();
        selectedFeeling = feelingName;
    }
}
