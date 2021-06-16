package com.jet.apiwhisky.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;

import com.jet.apiwhisky.Models.Whisky;
import com.jet.apiwhisky.R;

import org.w3c.dom.Text;

import java.util.List;

public class WhiskyInfoAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Whisky> myWhiskyInfo;

    public WhiskyInfoAdapter(Activity activity, List<Whisky> myWhiskyInfo) {
        this.activity = activity;
        this.myWhiskyInfo = myWhiskyInfo;
    }

    @Override
    public int getCount() {
        return myWhiskyInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return myWhiskyInfo.get(position);
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
            v = inf.inflate(R.layout.whiskyinfoitem, null);
        }

        Whisky whisky = myWhiskyInfo.get(position);
        TextView slug = v.findViewById(R.id.TvSlug);
        TextView buyers = v.findViewById(R.id.tvBuyers);
        TextView sellers= v.findViewById(R.id.tvSellers);
        Button url = v.findViewById(R.id.btnUrl);

        slug.setText(whisky.getWhiskySlug());
        buyers.setText(whisky.getWhiskyBuyers());
        sellers.setText(whisky.getWhiskySellers());

        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _btnLink = Uri.parse(whisky.getWhiskyUrl());
                Intent i = new Intent(Intent.ACTION_VIEW, _btnLink);
                activity.startActivity(i);
            }
        });


        return v;
    }
}
