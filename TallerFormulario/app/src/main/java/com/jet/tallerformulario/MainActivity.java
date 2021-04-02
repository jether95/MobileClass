package com.jet.tallerformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtLastName;
    private EditText txtEmail;
    private EditText txtAge;
    private EditText txtSalary;
    private EditText txtPosition;
    private Button btnSave;
    private TextView tvList;

    private Persona objPersona;
    private ArrayList<Persona> PersonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtlastName);
        txtEmail = findViewById(R.id.txtEmail);
        txtAge = findViewById(R.id.txtAge);
        txtSalary = findViewById(R.id.txtSalary);
        txtPosition = findViewById(R.id.txtPosition);
        tvList = findViewById(R.id.tvList);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);

        objPersona = new Persona(txtName, txtLastName, txtEmail, txtAge, txtSalary, txtPosition);


    }

    @Override
    public void onClick(View v) {
        String result ="";
        PersonList.add(objPersona);

        for (int i = 0; i < PersonList.size(); i++){
            if(i + 1 < PersonList.size())
                result += PersonList.get(i).toString() + " | ";
            else
                result += PersonList.get(i).toString();
        }

        tvList.setText(String.format(result));
    }
}