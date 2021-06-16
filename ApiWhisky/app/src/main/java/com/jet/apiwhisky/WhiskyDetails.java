package com.jet.apiwhisky;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jet.apiwhisky.Adapters.WhiskyInfoAdapter;
import com.jet.apiwhisky.ApiManager.RetrofitClient;
import com.jet.apiwhisky.Models.Whisky;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WhiskyDetails extends AppCompatActivity {

    ListView WhiskyInfoList;
    ArrayList<Whisky> myWhiskyInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whisky_details);

        WhiskyInfoList = findViewById(R.id.listWhiskyInfo);

        WhiskyDetailsApi();
    }

    private void WhiskyDetailsApi() {
        Call<ArrayList<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhiskyDetails();
        call.enqueue(new Callback<ArrayList<Whisky>>() {
            @Override
            public void onResponse(Call<ArrayList<Whisky>> call, Response<ArrayList<Whisky>> response) {
                myWhiskyInfo = response.body();
                WhiskyInfoAdapter adapter = new WhiskyInfoAdapter(WhiskyDetails.this, myWhiskyInfo);
                WhiskyInfoList.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Whisky>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });


    }

}