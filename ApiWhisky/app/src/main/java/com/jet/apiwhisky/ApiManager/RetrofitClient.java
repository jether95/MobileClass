package com.jet.apiwhisky.ApiManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private ApiWhisky myApi;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiWhisky.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi = retrofit.create(ApiWhisky.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiWhisky getMyApi(){
        return myApi;
    }
}
