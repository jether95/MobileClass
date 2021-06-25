package com.jet.dataaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtId;
    private EditText txtName;
    private EditText txtPoblacion;
    private EditText txtLatitud;
    private EditText txtLongitud;
    private Button btnSave;
    private Button btnList;
    private ListView lvListar;
    private ArrayAdapter<String> adapter;
    MyDbHelper db = new MyDbHelper(this);
    ArrayList<Area> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtPoblacion = findViewById(R.id.txtPoblacion);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        btnSave = findViewById(R.id.btnSave);
        btnList = findViewById(R.id.btnList);
        lvListar = findViewById(R.id.lvListar);

        btnSave.setOnClickListener(this);



        /*
        Set<String> set = new HashSet<>();

        set.add("11");
        set.add("12");
        set.add("13");

        SharedPreferences sharedPref = getSharedPreferences("Materia1" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", "juaco@gmail.com");
        editor.putString("nombre", "juaco");
        editor.commit();

        String correo = sharedPref.getString("email", "");
        String nombre = sharedPref.getString("nombre", "");
        ArrayList datos = (ArrayList) sharedPref.getStringSet("datos", null);

         */
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                agregarCiudad();
                break;
            case R.id.btnList:
                cities = db.selectCity(db.getWritableDatabase());
                ordenarAlfabeticamente();
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
                lvListar.setAdapter(adapter);
                break;
        }
    }

    private void agregarCiudad() {
        int id = Integer.parseInt(txtId.getText().toString());
        String nombre = txtName.getText().toString();
        int poblacion = Integer.parseInt(txtPoblacion.getText().toString());
        double latitud = Double.parseDouble(txtLatitud.getText().toString());
        double longitud = Double.parseDouble(txtLongitud.getText().toString());

        Area city = new Area(id, nombre, poblacion, latitud, longitud);
        db.insertArea(db.getWritableDatabase(), city);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.getText().clear();
        txtName.getText().clear();
        txtPoblacion.getText().clear();
        txtLatitud.getText().clear();
        txtLongitud.getText().clear();
    }

    private void ordenarAlfabeticamente() {
        Collections.sort(cities, new Comparator<Area>() {
            @Override
            public int compare(Area c1, Area c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });

    }
}