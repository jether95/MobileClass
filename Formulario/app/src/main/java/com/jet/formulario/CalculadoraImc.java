package com.jet.formulario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculadoraImc extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInformation;
    private EditText txtHeight;
    private EditText txtWeight;
    private Button btnCalculator;
    private ImageView imgEstate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameCalculator");
        String surname = intent.getStringExtra("surnameCalculator");
        String email = intent.getStringExtra("emailCalculator");
        String message = "Hola" + name + " " + surname + " " + "es un gusto tenerte aca tu correo para el informe es: "+email;

        tvInformation = findViewById(R.id.tvInformation);
        tvResult = findViewById(R.id.tvResult);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        btnCalculator = findViewById(R.id.btnCalculator);
        imgEstate = findViewById(R.id.imgState);
        tvInformation.setText(message);
        btnCalculator.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCalculator){
            
        }

    }

    public void ImcCalculator(){

    }
}