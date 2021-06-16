package com.jet.finalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.finalproyect.BreakingBadApi.QuotesAdapter;
import com.jet.finalproyect.Models.Quotes;
import com.jet.finalproyect.Models.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesApi extends AppCompatActivity {

    ListView listQuote;
    ArrayList<Quotes> myQuoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_api);

        listQuote = findViewById(R.id.quotesListView);
        getFromApiQuotes();

    }

    private void getFromApiQuotes(){
        Call<ArrayList<Quotes>> call = RetrofitClient.getInstance().getMyApi().getQuotes();
        call.enqueue(new Callback<ArrayList<Quotes>>() {
            @Override
            public void onResponse(Call<ArrayList<Quotes>> call, Response<ArrayList<Quotes>> response) {
                myQuoteList = response.body();
                QuotesAdapter adapter = new QuotesAdapter(QuotesApi.this, myQuoteList);
                listQuote.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Quotes>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}