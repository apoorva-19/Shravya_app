package com.beproject.shravya;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.beproject.shravya.Retrofit_API.APIClient;
import com.beproject.shravya.Retrofit_API.ApiInterface;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private ApiInterface apiInterface;
    private Integer num = 0;
    private int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.adhyaya_list);
        apiInterface = APIClient.getApiClient().create(ApiInterface.class);
        final Call<NumberClass> number = apiInterface.getNumAdhyaya();
        final ArrayList<String> adhyaya_list = new ArrayList<>();
        number.enqueue(new Callback<NumberClass>() {
            @Override
            public void onResponse(Call<NumberClass> call, Response<NumberClass> response) {
                num = response.body().getNumber();
                populateListView(num, adhyaya_list);

            }

            @Override
            public void onFailure(Call<NumberClass> call, Throwable t) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //position gives us the position of the element that has been clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), ShlokaList.class);
                intent.putExtra("adhyayaNo", position + 1);
                startActivity(intent);
            }
        });
    }

    public void populateListView(int val, ArrayList<String> adhyaya_list) {
        for (int i = 1; i <= val; i++)
            adhyaya_list.add("Adhyaya " + i);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,adhyaya_list);

        listView.setAdapter(arrayAdapter);
    }
}
