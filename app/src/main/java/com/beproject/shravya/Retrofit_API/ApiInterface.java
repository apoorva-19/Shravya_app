package com.beproject.shravya.Retrofit_API;

import com.beproject.shravya.InfoClass;
import com.beproject.shravya.NumberClass;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Content-Type: application/json")

    @GET("/")
    Call<NumberClass> getNumAdhyaya();

    @GET("/shloka_number/{chapter}")
    Call<Integer> getNumShloka(@Path("chapter") int chapter);

    @GET("/shlokas")
    Call<List<InfoClass>> getInfromation();
}
