package com.jet.apiwhisky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.apiwhisky.Adapters.DistilleryAdapter;
import com.jet.apiwhisky.ApiManager.RetrofitClient;
import com.jet.apiwhisky.Models.Distillery;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistilleryApi extends AppCompatActivity implements AdapterView.OnItemClickListener {
     ListView distilleryList;
     ArrayList<Distillery> myDistilleries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distillery_api);
        getFromInternetDistilleries();
        distilleryList = findViewById(R.id.listDistillery);
        distilleryList.setOnItemClickListener(this);

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
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

