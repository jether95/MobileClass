package com.jet.designpatterns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jet.designpatterns.Models.Car;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView ListViewNames;
    private ArrayList<Car> listCars = new ArrayList<>();
    //private String[] names = {"Juaco", "Raul", "Pedro"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewNames = findViewById(R.id.listViewNames);
        //Car c = new Car("FORD MUSTANG", "200", "2021", "140000000",null);
        listCars.add(new Car("FORD MUSTANG", "200", "2021", "140000000",null));
        listCars.add(new Car("CAMARO", "200", "2021", "140000000",null));
        listCars.add(new Car("COBRA", "200", "1966", "140000000",null));

        AdapterCar adapter = new AdapterCar(this, listCars);

        ListViewNames.setAdapter(adapter);
        ListViewNames.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "ha pulsado el elemento numero "+position, Toast.LENGTH_LONG).show();
    }
}