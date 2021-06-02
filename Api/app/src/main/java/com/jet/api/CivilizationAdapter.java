package com.jet.api;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.api.models.Civilization;

import java.util.ArrayList;
import java.util.List;

public class CivilizationAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Civilization> myCivilization;

    public CivilizationAdapter(Activity activity, List<Civilization> civilizationsList){
        this.activity = activity;
        this.myCivilization = civilizationsList;
    }

    @Override
    public int getCount() {
        return myCivilization.size();
    }

    @Override
    public Object getItem(int position) {
        return myCivilization.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.civilization_item, null);
        }

        Civilization civilization = myCivilization.get(position);
        TextView nameCivilization = v.findViewById(R.id.tvName);
        nameCivilization.setText(civilization.getNameCivilization());

        TextView idCivilization = v.findViewById(R.id.tvId);
        idCivilization.setText(civilization.getIdCivilization());

        return v;
    }
}
