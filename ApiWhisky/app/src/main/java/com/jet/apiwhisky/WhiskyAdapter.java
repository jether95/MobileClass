package com.jet.apiwhisky;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.apiwhisky.Models.Whisky;
import com.jet.apiwhisky.R;

import java.util.List;

public class WhiskyAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Whisky> myWhisky;

    public WhiskyAdapter(Activity activity, List<Whisky> myWhiskyList) {
        this.activity = activity;
        this.myWhisky = myWhiskyList;
    }

    @Override
    public int getCount() {
        return myWhisky.size();
    }

    @Override
    public Object getItem(int position) {
        return myWhisky.get(position);
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

        Whisky whisky = myWhisky.get(position);
        TextView nameWhisky = v.findViewById(R.id.tvName);
        nameWhisky.setText(whisky.getWhiskyName());


        return v;
    }
}
