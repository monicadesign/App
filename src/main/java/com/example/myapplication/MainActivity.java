package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        /*Declarações
         */
        Button btn_logIn = findViewById(R.id.btn_go_to_login);
        Button btn_registar = findViewById(R.id.btn_go_to_regist);

        //this.startActivity(new Intent(this, Register.class));
        btn_registar.setOnClickListener(this);
        btn_logIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == findViewById(R.id.btn_go_to_regist) ){
           Intent go_to_regist = new Intent (this,Register.class);
           this.startActivity(go_to_regist);
        }
        if (v == findViewById(R.id.btn_go_to_login)){
            this.startActivity(new Intent(this,LogInActivity.class));
        }

    }
}