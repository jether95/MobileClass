package com.jet.finalproyect.BreakingBadApi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.finalproyect.Models.Episodes;
import com.jet.finalproyect.R;

import java.util.List;

public class EpisodesAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Episodes> myEpisodes;

    public EpisodesAdapter(Activity activity, List<Episodes> myEpisodes) {
        this.activity = activity;
        this.myEpisodes = myEpisodes;
    }

    @Override
    public int getCount() {
        return myEpisodes.size();
    }

    @Override
    public Object getItem(int position) {
        return myEpisodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(convertView == null){
            LayoutInflater inflaterEpisode = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflaterEpisode.inflate(R.layout.episodeitem, null);
        }

        Episodes episodes = myEpisodes.get(position);
        TextView tvEpisode = v.findViewById(R.id.tvEpisode);
        TextView tvTitle = v.findViewById(R.id.tvTitle);
        TextView tvSeason = v.findViewById(R.id.tvSeason);

        tvEpisode.setText(episodes.getEpisode());
        tvTitle.setText(episodes.getTitle());
        tvSeason.setText(episodes.getSeason());
        return v;
    }
}
