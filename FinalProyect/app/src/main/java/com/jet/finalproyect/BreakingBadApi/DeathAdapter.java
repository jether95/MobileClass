package com.jet.finalproyect.BreakingBadApi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.finalproyect.Models.Deaths;
import com.jet.finalproyect.Models.RetrofitClient;
import com.jet.finalproyect.R;

import java.util.List;

public class DeathAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Deaths> deathList;

    public DeathAdapter(Activity activity, List<Deaths> deathList) {
        this.activity = activity;
        this.deathList = deathList;
    }

    @Override
    public int getCount() {
        return deathList.size();
    }

    @Override
    public Object getItem(int position) {
        return deathList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null){
            LayoutInflater deathInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = deathInflater.inflate(R.layout.deathsitem, null);
        }

        Deaths deathsObj = deathList.get(position);
        TextView tvDeath = v.findViewById(R.id.tvDeath);
        TextView tvCause = v.findViewById(R.id.tvCause);
        TextView tvResponsible = v.findViewById(R.id.tvResponsible);
        TextView tvSeason = v.findViewById(R.id.tvDeathSeason);
        TextView tvEpisode = v.findViewById(R.id.tvDeathEpisode);

        tvDeath.setText(deathsObj.getDeath());
        tvCause.setText(deathsObj.getCause());
        tvResponsible.setText(deathsObj.getResponsible());
        tvSeason.setText(deathsObj.getSeason());
        tvEpisode.setText(deathsObj.getEpisode());

        return v;
    }
}
