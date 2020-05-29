package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity implements View.OnClickListener {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.registo);

        Button btn_registar = findViewById(R.id.btn_go_to_regist);
        Button btn_voltar = findViewById(R.id.btn_go_to_main);

        btn_voltar.setOnClickListener(this);
        btn_registar.setOnClickListener(this);

    }
    @Override
    public void onClick(View view_clicada) {
        if (view_clicada == findViewById(R.id.btn_go_to_main)){
            this.startActivity( new Intent(this,MainActivity.class));
        }
        if (view_clicada == findViewById(R.id.btn_go_to_regist)){
            this.startActivity(new Intent(this,Register.class));
        }
    }
}
