package com.beproject.shravya;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.beproject.shravya.Retrofit_API.APIClient;
import com.beproject.shravya.Retrofit_API.ApiInterface;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShlokaList extends AppCompatActivity {

    ListView shlokaList;
    private Integer information;
    private ApiInterface apiInterface;
    private List<InfoClass> Shlokas;
//    private int posn_of_shloka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_shloka_list);
        shlokaList = findViewById(R.id.shlokaList);
        final Intent intent = getIntent();
        final int adhyayaNo = intent.getIntExtra("adhyayaNo", 0);
        final ArrayList<String> shloka_List = new ArrayList<>();
        Toast.makeText(this, "Adhyaya " + adhyayaNo, Toast.LENGTH_SHORT).show();

        apiInterface = APIClient.getApiClient().create(ApiInterface.class);
        Call<List<InfoClass>> shlokas = apiInterface.getInfromation();
        shlokas.enqueue(new Callback<List<InfoClass>>() {
            @Override
            public void onResponse(Call<List<InfoClass>> call, Response<List<InfoClass>> response) {
                Shlokas = response.body();
            }

            @Override
            public void onFailure(Call<List<InfoClass>> call, Throwable t) {
                Log.d("failure", "onFailure: I am here, empty");
            }

        });

        apiInterface = APIClient.getApiClient().create(ApiInterface.class);
        Call<Integer> info = apiInterface.getNumShloka(adhyayaNo);
        info.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                information = response.body();
                populateListView(information, shloka_List);
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
        shlokaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent next_intent = new Intent(ShlokaList.this, Shloka.class);
                Bundle bundle = new Bundle();
                int posn_of_shloka = position+1;
                String shloka_to_print = findRightShloka(posn_of_shloka,Shlokas);
                bundle.putString("Shloka_display", shloka_to_print);
                next_intent.putExtras(bundle);
                startActivity(next_intent);
            }
        });
    }
    public String findRightShloka(int posn_of_shloka, List<InfoClass> Shlokas){
        for(int i=0; i<=Shlokas.size(); i++) {
            InfoClass s = Shlokas.get(i);
            if(s.getVerse() == posn_of_shloka)
            {
                return s.getOrg_shloka();
            }

        }
        return null;
    }
    public void populateListView(int val, ArrayList<String> shloka_List) {
        for (int i = 1; i <= val; i++)
            shloka_List.add("Shloka " + i);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,shloka_List);

        shlokaList.setAdapter(arrayAdapter);
    }
}

