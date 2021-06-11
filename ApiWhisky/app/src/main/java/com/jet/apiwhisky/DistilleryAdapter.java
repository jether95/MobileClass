package com.jet.apiwhisky;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.apiwhisky.Models.Distillery;
import com.jet.apiwhisky.Models.Whisky;

import java.util.List;

public class DistilleryAdapter extends BaseAdapter{
    protected Activity activity;
    protected List<Distillery> myDistilleryList;

    public DistilleryAdapter(Activity activity, List<Distillery> myDistilleryList) {
        this.activity = activity;
        this.myDistilleryList = myDistilleryList;
    }

    @Override
    public int getCount() {
        return myDistilleryList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDistilleryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.whiskyitem, null);
        }
        Distillery distillery = myDistilleryList.get(position);
        TextView nameDistillery = v.findViewById(R.id.tvName);
        nameDistillery.setText(distillery.getDistilleryName());

        return v;
    }
}
