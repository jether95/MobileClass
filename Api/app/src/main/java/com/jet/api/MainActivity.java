package com.jet.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.jet.api.ApiManager.RetrofitClient;
import com.jet.api.models.Civilization;
import com.jet.api.models.Civilizations;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listCivilizations;
    Civilizations myCivilizations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCivilizations = findViewById(R.id.listCivilizations);
        getFromInternetCivilizations();

        listCivilizations.setOnItemClickListener(this);
    }

    private void getFromInternetCivilizations(){
        Call<Civilizations> call = RetrofitClient.getInstance().getMyApi().getCivilizations();
        call.enqueue(new Callback<Civilizations>() {
            @Override
            public void onResponse(Call<Civilizations> call, Response<Civilizations> response) {
                    myCivilizations = response.body();
                    String message = "";
                    CivilizationAdapter adapter = new CivilizationAdapter(MainActivity.this, myCivilizations.getCivilizationList());
                    listCivilizations.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Civilizations> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this, CivilizationDetail.class);
        in.putExtra("id", myCivilizations.getCivilizationList().get(position).getIdCivilization());
        startActivity(in);
    }
}