package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login1);

        Button btn_go_to_login = findViewById(R.id.btn_go_to_login);
        Button btn_voltar = findViewById(R.id.btn_go_to_main);

        btn_go_to_login.setOnClickListener(this);
        btn_voltar.setOnClickListener(this);
    }

      @Override
      public void onClick (View v) {
        if (v == findViewById(R.id.btn_go_to_main)){
            this.startActivity(new Intent(this,MainActivity.class));
        }
        if (v == findViewById(R.id.btn_go_to_login)){
            this.startActivity(new Intent(this,LogInActivity.class));
        }

    }
}
