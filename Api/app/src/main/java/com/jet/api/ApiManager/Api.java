package com.jet.api.ApiManager;

import com.jet.api.models.Civilization;
import com.jet.api.models.Civilizations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL ="https://age-of-empires-2-api.herokuapp.com/api/v1/";

    @GET("civilizations")
    Call<Civilizations> getCivilizations();
}
