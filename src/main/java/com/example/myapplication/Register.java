package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity implements View.OnClickListener {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.registo);

        Button btn_go_to_login = findViewById(R.id.btn_go_to_sobre);
        Button btn_voltar = findViewById(R.id.btn_go_to_main);

        btn_voltar.setOnClickListener(this);
        btn_go_to_login.setOnClickListener(this);

    }
    @Override
    public void onClick(View view_clicada) {
        if (view_clicada == findViewById(R.id.btn_go_to_main)){
            this.startActivity( new Intent(this,MainActivity.class));
        }
        if (view_clicada == findViewById(R.id.btn_go_to_sobre)){
            this.startActivity(new Intent(this,LogInActivity.class));
        }
    }
}
