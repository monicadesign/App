package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.registo);

        Button btn_go_to_login = findViewById(R.id.btn_go_to_sobre);
        Button btn_voltar = findViewById(R.id.btn_go_to_main);

        btn_voltar.setOnClickListener(this);
        btn_go_to_login.setOnClickListener(this);

        //Area Spinner
        Spinner spinner = findViewById(R.id.aSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Distritos,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
        if (position == 0) {
            Toast.makeText(getApplicationContext(),"Este é o item nº0",Toast.LENGTH_LONG).show();
            ((TextView)parent.getChildAt(0)).setTextColor(getColor(R.color.appcolor3));
        }

        parent.getChildAt(0).setFocusable(false);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
