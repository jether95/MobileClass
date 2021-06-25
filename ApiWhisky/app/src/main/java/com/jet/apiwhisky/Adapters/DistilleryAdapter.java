package com.jet.apiwhisky.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.apiwhisky.Models.Distillery;
import com.jet.apiwhisky.Models.Whisky;
import com.jet.apiwhisky.R;

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
        View vDes = convertView;
        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vDes = inf.inflate(R.layout.whiskyitem, null);
        }
        Distillery distillery = myDistilleryList.get(position);
        TextView nameDistillery = vDes.findViewById(R.id.tvName);
        nameDistillery.setText(distillery.getDistilleryName());

        return vDes;
    }
}
