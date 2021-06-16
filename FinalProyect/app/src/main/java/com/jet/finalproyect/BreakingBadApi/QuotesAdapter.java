package com.jet.finalproyect.BreakingBadApi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.finalproyect.Models.Quotes;
import com.jet.finalproyect.R;

import java.util.List;

public class QuotesAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Quotes> myQuotes;

    public QuotesAdapter(Activity activity, List<Quotes> myQuotes) {
        this.activity = activity;
        this.myQuotes = myQuotes;
    }

    @Override
    public int getCount() {
        return myQuotes.size();
    }

    @Override
    public Object getItem(int position) {
        return myQuotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null ){
            LayoutInflater inflaterQuote = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflaterQuote.inflate(R.layout.quotesitem, null);
        }

        Quotes quotesObj = myQuotes.get(position);

        TextView series = v.findViewById(R.id.tvSerie);
        TextView quotes = v.findViewById(R.id.tvQuote);
        TextView author = v.findViewById(R.id.tvAuthor);

        series.setText(quotesObj.getSeries());
        quotes.setText('"'+quotesObj.getQuote()+'"');
        author.setText(quotesObj.getAuthor());

        return v;
    }
}
