package com.jet.api;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.jet.api.ApiManager.RetrofitClient;
import com.jet.api.models.Civilization;
import com.jet.api.models.Civilizations;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listCivilizations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCivilizations = findViewById(R.id.listCivilizations);
        getFromInternetCivilizations();
    }

    private void getFromInternetCivilizations(){
        Call<Civilizations> call = RetrofitClient.getInstance().getMyApi().getCivilizations();
        call.enqueue(new Callback<Civilizations>() {
            @Override
            public void onResponse(Call<Civilizations> call, Response<Civilizations> response) {
                    Civilizations myCivilizations = response.body();
                    String message = "";
                    CivilizationAdapter adapter = new CivilizationAdapter(MainActivity.this, myCivilizations.getCivilizationList());
                    listCivilizations.setAdapter(adapter);

                /*for (int i = 0; i < myCivilizations.getCivilizationList().size(); i++){
                    message = message + myCivilizations.getCivilizationList().get(i).getNameCivilization() + " : ";
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onFailure(Call<Civilizations> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}