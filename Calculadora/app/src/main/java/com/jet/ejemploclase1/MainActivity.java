package com.jet.ejemploclase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etLoginName;
    private EditText etLoginPassword;
    private Button btnLoginSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView();
        btnLoginSend.setOnClickListener(this);
        etLoginName.setOnClickListener(this);
        etLoginPassword.setOnClickListener(this);

    }

    private void setContentView(){
        etLoginName = findViewById(R.id.txtUsername);
        etLoginPassword = findViewById(R.id.txtPassword);
        btnLoginSend = findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLogin){
            sendLogin();
        }
    }

    private void sendLogin(){
        if(etLoginName.getText().toString().equalsIgnoreCase("juaco") && etLoginPassword.getText().toString().equalsIgnoreCase("1234")){
            Intent calculatorIntent = new Intent(this, CalculatorActivity.class);
            startActivity(calculatorIntent);
            this.onDestroy();
        }

    }

    /*
    ejemplo
    private void sendLogin() {
        String fullText = etLoginName.getText().toString();
        Toast.makeText(this,"hola "+ fullText,Toast.LENGTH_LONG).show();
    }

     */
}