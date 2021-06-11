package com.jet.apiwhisky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.apiwhisky.ApiManager.RetrofitClient;
import com.jet.apiwhisky.Models.Whisky;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WhiskyApi extends AppCompatActivity implements View.OnClickListener {

    ListView listWhiskey;
    ArrayList<Whisky> myWhiskys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whisky_api);
        getFromInternetWhisky();

        listWhiskey = findViewById(R.id.listWhisky);

    }

    private void getFromInternetWhisky(){
        Call<ArrayList<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhiskys();
        call.enqueue(new Callback<ArrayList<Whisky>>() {

            @Override
            public void onResponse(Call<ArrayList<Whisky>> call, Response<ArrayList<Whisky>> response) {
                myWhiskys = response.body();
                WhiskyAdapter adapter = new WhiskyAdapter(WhiskyApi.this, myWhiskys);
                listWhiskey.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Whisky>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}