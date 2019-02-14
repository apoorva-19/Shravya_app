package com.beproject.shravya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.beproject.shravya.Retrofit_API.APIClient;
import com.beproject.shravya.Retrofit_API.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Shloka extends AppCompatActivity {

    TextView textView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter adapter;
    private List<InfoClass> information;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shloka);

        textView = (TextView)findViewById(R.id.shlokaText);
        Bundle bundle = getIntent().getExtras();
        int shlokaNo = bundle.getInt("shlokaNo");
        int adhyayaNo = bundle.getInt("adhyayaNo");
        String Shloka_display = bundle.getString("Shloka_display");
        textView.setText(Shloka_display);
    }
}
