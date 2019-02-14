package com.beproject.shravya.Retrofit_API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BASE_URL = "http://192.168.43.171:5000/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if(retrofit == null){
            retrofit =  new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
