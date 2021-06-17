package com.jet.finalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.finalproyect.BreakingBadApi.DeathAdapter;
import com.jet.finalproyect.Models.Deaths;
import com.jet.finalproyect.Models.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeathsApi extends AppCompatActivity {

    ListView deathsList;
    ArrayList<Deaths> myDeathsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deaths_api);

        deathsList = findViewById(R.id.DeathListView);
        getFromApiDeath();

    }

    private void getFromApiDeath(){
        Call<ArrayList<Deaths>> call =RetrofitClient.getInstance().getMyApi().getDeath();
        call.enqueue(new Callback<ArrayList<Deaths>>() {
            @Override
            public void onResponse(Call<ArrayList<Deaths>> call, Response<ArrayList<Deaths>> response) {
                myDeathsList = response.body();
                DeathAdapter deathAdapter = new DeathAdapter(DeathsApi.this, myDeathsList);
                deathsList.setAdapter(deathAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Deaths>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}