package com.jet.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.jet.api.ApiManager.RetrofitClient;
import com.jet.api.models.Civilization;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CivilizationDetail extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilization_detail);

        Bundle in = getIntent().getExtras();
        id = in.getString("id");

        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        getCivilizationById(id);

    }

    private void getCivilizationById(String id){
        Call<Civilization> call = RetrofitClient.getInstance().getMyApi().getCivilization(id);
        call.enqueue(new Callback<Civilization>() {
            @Override
            public void onResponse(Call<Civilization> call, Response<Civilization> response) {
                Civilization myCivilization = response.body();
                Toast.makeText(getApplicationContext(), myCivilization.getNameCivilization(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Civilization> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurre un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}