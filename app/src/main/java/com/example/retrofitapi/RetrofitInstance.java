package com.example.retrofitapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.retrofitapi.MainActivity.api;

public class RetrofitInstance {

    public static RetrofitInstance instance;
    ApiInterface apiInterface;

    RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance==null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }
}
