package com.jet.finalproyect.BreakingBadApi;

import com.jet.finalproyect.Models.Characters;
import com.jet.finalproyect.Models.Episodes;
import com.jet.finalproyect.Models.Quotes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiBreakingBad {
    String BASE_URL="https://www.breakingbadapi.com/api/";

    @GET("characters")
    Call<ArrayList<Characters>> getCharacters();

    @GET("episodes")
    Call<ArrayList<Episodes>> getEpisodes();

    @GET("quotes")
    Call<ArrayList<Quotes>> getQuotes();

}
