package com.jet.finalproyect.Models;

import com.jet.finalproyect.BreakingBadApi.ApiBreakingBad;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private ApiBreakingBad myApi;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiBreakingBad.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi = retrofit.create(ApiBreakingBad.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiBreakingBad getMyApi(){
        return myApi;
    }
}
