package com.jet.apiwhisky.ApiManager;

import com.jet.apiwhisky.Models.Whisky;
import com.jet.apiwhisky.Models.Whiskys;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiWhisky {
    String BASE_URL="https://whiskyhunter.net/api/";

    @GET("auctions_info")
    Call<Whiskys> getWhiskys();

}
