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
        String message = "Hola " + name + " " + surname + " " + "es un gusto tenerte aca tu correo para el informe es: "+email;


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
            ImcCalculator(Double.parseDouble(txtHeight.getText().toString()), Integer.parseInt(txtWeight.getText().toString()));
        }

    }

    public void ImcCalculator(double height, int weight){
        double operation = weight/Math.pow(height, 2);
        String state;

        if(operation < 18.5){
            state = "BAJO PESO - su IMC esta por debajo de 18.5";
            tvResult.setText(String.format("%.3f", operation)+ "\n"+state);
            imgEstate.setImageResource(R.drawable.bajopeso);
        }else if(operation >= 18.5 && operation <= 24.9){
            state = "NORMAL - su IMC esta entre 18.5 y 24.9";
            tvResult.setText(String.format("%.3f", operation)+ "\n"+state);
            imgEstate.setImageResource(R.drawable.normal1);

        }else if(operation >= 25.0 && operation <= 29.9){
            state = "SOBREPESO - su IMC esta entre 25.0 y 29.9";
            tvResult.setText(String.format("%.3f", operation)+ "\n"+state);
            imgEstate.setImageResource(R.drawable.sobrepeso);

        }else{
            state = "OBESO - su IMC esta por encima de 30.0";
            tvResult.setText(String.format("%.3f", operation)+ "\n"+state);
            imgEstate.setImageResource(R.drawable.obeso);
        }

    }
}