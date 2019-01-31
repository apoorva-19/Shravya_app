package com.beproject.shravya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShlokaList extends AppCompatActivity {

    ListView shlokaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shloka_list);

        final Intent intent = getIntent();
        final int adhyayaNo = intent.getIntExtra("adhyayaNo",0);

        Toast.makeText(this, "Adhyaya "+adhyayaNo, Toast.LENGTH_SHORT).show();

        shlokaList = (ListView)findViewById(R.id.shlokaList);

        ArrayList<String> arrayList = new ArrayList<>();

        int limit = (int)(Math.random() * 50 + 1);
        for(int i = 1; i<=limit; i++)
            arrayList.add("Shloka "+i);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        shlokaList.setAdapter(arrayAdapter);

        shlokaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent next_intent = new Intent(ShlokaList.this, Shloka.class);
                Bundle bundle = new Bundle();
                bundle.putInt("shlokaNo", position+1);
                bundle.putInt("adhyayaNo", adhyayaNo);
                next_intent.putExtras(bundle);
                startActivity(next_intent);
            }
        });

    }
}
