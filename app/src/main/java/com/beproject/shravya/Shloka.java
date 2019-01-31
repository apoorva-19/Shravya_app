package com.beproject.shravya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Shloka extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shloka);

        textView = (TextView)findViewById(R.id.shlokaText);
        Bundle bundle = getIntent().getExtras();
        int shlokaNo = bundle.getInt("shlokaNo");
        int adhyayaNo = bundle.getInt("adhyayaNo");

        textView.setText("You clicked on shloka "+shlokaNo+" of adhyaya "+adhyayaNo);

    }
}
