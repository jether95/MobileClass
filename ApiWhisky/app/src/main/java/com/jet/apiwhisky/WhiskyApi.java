package com.jet.apiwhisky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.apiwhisky.ApiManager.RetrofitClient;
import com.jet.apiwhisky.Models.Whiskys;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WhiskyApi extends AppCompatActivity implements View.OnClickListener {

    ListView listWhiskey;
    Whiskys myWhiskys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whisky_api);
        getFromInternetWhisky();

        listWhiskey = findViewById(R.id.listWhisky);

    }

    private void getFromInternetWhisky(){
        Call<Whiskys> call = RetrofitClient.getInstance().getMyApi().getWhiskys();
        call.enqueue(new Callback<Whiskys>() {

            @Override
            public void onResponse(Call<Whiskys> call, Response<Whiskys> response) {
                myWhiskys = response.body();
                WhiskyAdapter adapter = new WhiskyAdapter(WhiskyApi.this, myWhiskys.getWhiskyList());
                listWhiskey.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Whiskys> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}