package com.jet.ejemploclase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainClaculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private Button btnNumberOne;
    private Button btnNumberTwo;
    private Button btnNumberThree;
    private Button btnNumberFour;
    private Button btnNumberFive;
    private Button btnNumberSix;
    private Button btnNumberSeven;
    private Button btnNumberEight;
    private Button btnNumberNine;
    private Button btnNumberZero;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivision;
    private Button btnEquals;
    private Button btnClear;

    int numberOne = 0;
    int numberTwo = 0;
    String operation = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_claculator);
        setView();
    }

    public void setView(){
        txtResult = findViewById(R.id.txtResult);
        btnNumberOne = findViewById(R.id.btnOne);
        btnNumberTwo = findViewById(R.id.btnTwo);
        btnNumberThree = findViewById(R.id.btnThree);
        btnNumberFour = findViewById(R.id.btnFour);
        btnNumberFive = findViewById(R.id.btnFive);
        btnNumberSix = findViewById(R.id.btnSix);
        btnNumberSeven = findViewById(R.id.btnSeven);
        btnNumberEight = findViewById(R.id.btnEight);
        btnNumberNine = findViewById(R.id.btnNine);
        btnNumberZero = findViewById(R.id.btnZero);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        btnEquals = findViewById(R.id.btnEquals);
        btnClear = findViewById(R.id.btnClear);

        btnNumberOne.setOnClickListener(this);
        btnNumberTwo.setOnClickListener(this);
        btnNumberThree.setOnClickListener(this);
        btnNumberFour.setOnClickListener(this);
        btnNumberFive.setOnClickListener(this);
        btnNumberSix.setOnClickListener(this);
        btnNumberSeven.setOnClickListener(this);
        btnNumberEight.setOnClickListener(this);
        btnNumberNine.setOnClickListener(this);
        btnNumberZero.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnClear){
           resetValues();
        }
        else if(v.getId() == R.id.btnDivision){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "division");

        }
        else if(v.getId() == R.id.btnPlus){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "plus");

        }
        else if(v.getId() == R.id.btnMinus){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "minus");

        }
        else if(v.getId() == R.id.btnMultiply){
            makeOperation(Integer.parseInt(txtResult.getText().toString()), "multiply");

        }
        else if(v.getId() == R.id.btnEquals){

        }
        else{
            if(operation.equalsIgnoreCase("") && numberOne != 0){
                txtResult.setText("");
            }
            Button btnSelectedButton = findViewById(v.getId());
            txtResult.setText(txtResult.getText() + btnSelectedButton.getText().toString());
        }
    }

    private void makeOperation (int number, String operationSelected){
        txtResult.setText("");
        if(numberOne != 0){
            numberTwo = number;
            resultOperation(operation);
            operation = operationSelected;
        }
        else{
            operation = operationSelected;
            numberOne = number;
        }
    }

    private void resultOperation(String operation){
        if (operation.equalsIgnoreCase("plus")){
            numberOne = numberOne + numberTwo;
        }
        else if(operation.equalsIgnoreCase("minus")){
            numberOne = numberOne - numberTwo;
        }else if (operation.equalsIgnoreCase("multiply")){
            numberOne = numberOne * numberTwo;
        }
        else{
            Double result = (double)numberOne/(double)numberTwo;
            numberOne = Integer.parseInt(String.valueOf(result));
            txtResult.setText(result.toString());
        }

        if(!operation.equalsIgnoreCase("division")){
            txtResult.setText(String.valueOf(numberOne));
        }
    }

    private  void resetValues(){
        txtResult.setText("");
        numberOne = 0;
        numberTwo = 0;
        operation = "";

    }

}