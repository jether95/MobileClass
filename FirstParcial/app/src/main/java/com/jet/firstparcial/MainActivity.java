package com.jet.firstparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtName;
    EditText txtCode;
    EditText txtValue;
    CheckBox checkIva;
    EditText txtDescription;
    Spinner spCategory;
    TextView tvResult;

    Button btnSave;
    Button btnIvaInformation;
    Button btnExpensive;
    Button btnCheap;

    ArrayList<Product> ProductList = new ArrayList();
    ArrayList<Double> OrderList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtCode = findViewById(R.id.txtCode);
        txtValue = findViewById(R.id.txtValue);
        checkIva = findViewById(R.id.checkIva);
        txtDescription = findViewById(R.id.txtDescription);
        spCategory = findViewById(R.id.spinnerCategory);

        tvResult = findViewById(R.id.tvResult);

        btnSave = findViewById(R.id.btnSave);
        btnIvaInformation = findViewById(R.id.btnIvaInformation);
        btnExpensive = findViewById(R.id.btnExpensive);
        btnCheap = findViewById(R.id.btnCheap);

        btnSave.setOnClickListener(this);
        btnIvaInformation.setOnClickListener(this);
        btnExpensive.setOnClickListener(this);
        btnCheap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnSave){
            String name = txtName.getText().toString();
            Integer code = Integer.parseInt(txtCode.getText().toString());
            Double value = Double.parseDouble(txtValue.getText().toString());
            Boolean check = checkIva.isChecked();
            String description = txtDescription.getText().toString();
            String category = spCategory.getSelectedItem().toString();

            String message = "";

            Product objectProduct = new Product(name, code, value, check, description, category);
            ProductList.add(objectProduct);

            for(int i = 0; i<ProductList.size(); i++){
                message = ProductList.toString()+"\n";
            }
            tvResult.setText(message);

        }

        else if(v.getId() == R.id.btnExpensive){
            String expensive = "";
            orderPrices();
            for (int i = 0; i< 10; i++) {
                expensive = OrderList.toString()+"\n";
            }
            tvResult.setText(expensive);

        }

        else if(v.getId() == R.id.btnCheap){
            String cheap = "";
            orderPrices();
            for (int i = 10; i>=0; i--) {
                cheap = OrderList.toString();
            }
            tvResult.setText(cheap);
        }
    }

    public ArrayList orderPrices(){
        for(int i = 0; i < ProductList.size(); i++){
            OrderList.add(ProductList.get(i).getValue());
        }
        Collections.sort(OrderList);
        return OrderList;
    }

}