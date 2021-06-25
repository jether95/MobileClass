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

    private Integer numberOne = 0;
    private Integer numberTwo = 0;
    private Integer result;
    private Integer operation = 0;



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
        if (v.getId() == R.id.btnClear) {
            clear();
        }
        else if (v.getId() == R.id.btnPlus) {
            add();
        }
        else if (v.getId() == R.id.btnMinus) {
            subtract();
        }
        else if (v.getId() == R.id.btnDivision) {
            divide();
        }
        else if (v.getId() == R.id.btnMultiply) {
            multiply();
        }
        else if (v.getId() == R.id.btnEquals) {
            equal();
        }
        else{
            Button btnSelected = findViewById(v.getId());
            txtResult.setText(txtResult.getText() + btnSelected.getText().toString());
        }
    }

    public void clear() {
        txtResult.setText("");
    }

    public void add() {
        numberOne = (Integer.parseInt(txtResult.getText().toString()));
        operation = 1;
        clear();
    }

    public void subtract() {
        numberOne = (Integer.parseInt(txtResult.getText().toString()));
        operation = 2;
        clear();
    }

    public void divide() {
        numberOne = (Integer.parseInt(txtResult.getText().toString()));
        operation = 3;
        clear();
    }

    public void multiply() {
        numberOne = (Integer.parseInt(txtResult.getText().toString()));
        operation = 4;
        clear();
    }

    public void equal() {
        numberTwo = (Integer.parseInt(txtResult.getText().toString()));
        if (operation.equals(1)) {
            result = numberOne + numberTwo;
        }
        if (operation.equals(2)) {
            result = numberOne - numberTwo;
        }
        if (operation.equals(3)) {
            result = numberOne / numberTwo;
        }
        if (operation.equals(4)) {
            result = numberOne * numberTwo;
        }
        txtResult.setText(result.toString());

    }

}