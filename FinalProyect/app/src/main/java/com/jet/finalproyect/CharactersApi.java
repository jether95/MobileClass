package com.jet.finalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.finalproyect.BreakingBadApi.CharacterAdapter;
import com.jet.finalproyect.Models.Characters;
import com.jet.finalproyect.Models.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersApi extends AppCompatActivity {

    ListView listCharacter;
    ArrayList<Characters> myCharacterListApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_api);

        listCharacter = findViewById(R.id.characterListView);
        getFromApiCharacter();

    }

    private void getFromApiCharacter(){
        Call<ArrayList<Characters>> call = RetrofitClient.getInstance().getMyApi().getCharacters();
        call.enqueue(new Callback<ArrayList<Characters>>() {
            @Override
            public void onResponse(Call<ArrayList<Characters>> call, Response<ArrayList<Characters>> response) {
                myCharacterListApi = response.body();
                CharacterAdapter adapter = new CharacterAdapter(CharactersApi.this,myCharacterListApi);
                listCharacter.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Characters>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }


        });
    }
}