package com.jet.tallerformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtName;
    EditText txtLastName;
    EditText txtEmail;
    EditText txtAge;
    EditText txtSalary;
    EditText txtPosition;

    Button btnSave;
    Button btnConsultation;
    Button btnYounger;
    TextView tvList;


    ArrayList<Persona> PersonList = new ArrayList();
    ArrayList<Integer> orderList = new ArrayList();


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
        btnYounger = findViewById(R.id.btnYounger);


        btnSave.setOnClickListener(this);
        btnConsultation.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave){

            String name =txtName.getText().toString();
            String lastName = txtLastName.getText().toString();
            Integer age = Integer.parseInt(txtAge.getText().toString());
            Integer salary = Integer.parseInt(txtSalary.getText().toString());
            String position = txtPosition.getText().toString();
            String email = txtEmail.getText().toString();

            String message = "";

            Persona objPersona = new Persona(name, lastName, email, age, salary, position);
            PersonList.add(objPersona);
            for(int i = 0; i<PersonList.size(); i++){
                message = PersonList.get(i).toString()+"\n";
            }
            tvList.setText(message);
        }
        else if(v.getId() == R.id.btnYounger){
            String younger = "";
            orderAges();
            for (int i = orderList.size()-1; i>=0; i--) {
                younger =orderList.get(i).toString();
            }
            tvList.setText(younger);
        }

    }

    public ArrayList orderAges(){
        for (int i = 0; i < PersonList.size(); i++) {
            orderList.add(PersonList.get(i).getAge());
        }
        Collections.sort(orderList);
        return orderList;
    }

}