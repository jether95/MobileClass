package com.jet.finalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.finalproyect.BreakingBadApi.EpisodesAdapter;
import com.jet.finalproyect.Models.Episodes;
import com.jet.finalproyect.Models.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeApi extends AppCompatActivity {

    ListView episodesList;
    ArrayList<Episodes> myEpisodes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_api);

        episodesList = findViewById(R.id.episodeListView);
        getFromApiEpisodes();

    }

    private void getFromApiEpisodes(){
        Call<ArrayList<Episodes>> call = RetrofitClient.getInstance().getMyApi().getEpisodes();
        call.enqueue(new Callback<ArrayList<Episodes>>() {
            @Override
            public void onResponse(Call<ArrayList<Episodes>> call, Response<ArrayList<Episodes>> response) {
                myEpisodes = response.body();
                EpisodesAdapter episodesAdapter = new EpisodesAdapter(EpisodeApi.this, myEpisodes);
                episodesList.setAdapter(episodesAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Episodes>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}