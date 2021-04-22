package com.jet.dataaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtId;
    private EditText txtName;
    private Button btnSave;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);

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
        MyDbHelper db = new MyDbHelper(this);
        Area area = new Area();
        ArrayList<Area> areas = db.selectArea(db.getWritableDatabase());

        if(v.getId() == R.id.btnSave){
            area.setId(txtId.getText().toString());
            area.setName(txtName.getText().toString());
            db.insertArea(db.getReadableDatabase(),area);
            // id, nombre, poblacion, latitud, longitud
            for(Area areaSelected : areas){
                tvResult.setText("el area"+ areaSelected.getId()+" es igual a "+areaSelected.getName());
            }
        }
    }
}