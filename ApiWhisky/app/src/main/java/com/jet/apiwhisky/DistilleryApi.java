package com.jet.apiwhisky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.apiwhisky.ApiManager.RetrofitClient;
import com.jet.apiwhisky.Models.Distillery;
import com.jet.apiwhisky.Models.Whisky;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistilleryApi extends AppCompatActivity {
     ListView distilleryList;
     ArrayList<Distillery> myDistilleries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distillery_api);
        getFromInternetDistilleries();

        distilleryList = findViewById(R.id.listDistillery);
    }

    private void getFromInternetDistilleries(){
        Call<ArrayList<Distillery>> call = RetrofitClient.getInstance().getMyApi().getDistilleryName();
        call.enqueue(new Callback<ArrayList<Distillery>>() {
            @Override
            public void onResponse(Call<ArrayList<Distillery>> call, Response<ArrayList<Distillery>> response) {
                myDistilleries = response.body();
                DistilleryAdapter adapter = new DistilleryAdapter(DistilleryApi.this, myDistilleries);
                distilleryList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Distillery>> call, Throwable t) {

            }
        });
    }
}

