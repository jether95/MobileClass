package com.jet.apiwhisky.ApiManager;

import com.jet.apiwhisky.Models.Distillery;
import com.jet.apiwhisky.Models.Whisky;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiWhisky {
    String BASE_URL="https://whiskyhunter.net/api/";

    @GET("auctions_data")
    Call<ArrayList<Whisky>> getWhiskys();

    @GET("distilleries_info")
    Call<ArrayList<Distillery>> getDistilleryName();

    @GET("auctions_info")
    Call<ArrayList<Whisky>> getWhiskyDetails();



}
