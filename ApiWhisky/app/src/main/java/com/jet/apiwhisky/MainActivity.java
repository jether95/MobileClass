package com.jet.apiwhisky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgWhisky;
    private ImageButton imgDistillery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWhisky = findViewById(R.id.imgWhisky);
        imgDistillery = findViewById(R.id.imgDistillery);

        imgDistillery.setOnClickListener(this);
        imgWhisky.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imgWhisky){
            Intent whiskyIntent = new Intent(this, WhiskyApi.class);
            startActivity(whiskyIntent);

        }

        if(v.getId() == R.id.imgDistillery){
            Intent distilleryIntent = new Intent(this, DistilleryApi.class);
            startActivity(distilleryIntent);
        }

    }
}