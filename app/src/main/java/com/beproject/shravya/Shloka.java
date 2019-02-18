package com.beproject.shravya;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Shloka extends AppCompatActivity{

    TextView shlokaText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_shloka);
        shlokaText = findViewById(R.id.shlokaText);
        Bundle bundle = getIntent().getExtras();
        String Shloka_display = bundle.getString("Shloka_display");
        String[] shlokas = Shloka_display.split("।", 2);
        String displayShloka = shlokas[0] + "।\n" + shlokas[1];
        shlokaText.setText(displayShloka);
    }
}
