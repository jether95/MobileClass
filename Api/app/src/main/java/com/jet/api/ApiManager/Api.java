package com.jet.api.ApiManager;

import com.jet.api.models.Civilization;
import com.jet.api.models.Civilizations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL ="https://age-of-empires-2-api.herokuapp.com/api/v1/";

    /*name of api*/
    @GET("civilizations")
    Call<Civilizations> getCivilizations();

    @GET("civilization/{id}")
    Call<Civilization> getCivilization(@Path("id") String id);
}
