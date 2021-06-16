package com.jet.finalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button characters;
    private Button episodes;
    private Button quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characters = findViewById(R.id.btnCharacters);
        episodes = findViewById(R.id.btnEpisodes);
        quotes = findViewById(R.id.btnQuotes);

        episodes.setOnClickListener(this);
        characters.setOnClickListener(this);
        quotes.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnCharacters) {
            Intent characterIntent = new Intent(this, CharactersApi.class);
            startActivity(characterIntent);

        }
        if(v.getId() == R.id.btnEpisodes){
            Intent episodeIntent = new Intent(this, EpisodeApi.class);
            startActivity(episodeIntent);
        }

        if (v.getId() == R.id.btnQuotes){
            Intent quoteIntent = new Intent(this, QuotesApi.class);
            startActivity(quoteIntent);
        }

    }
}