package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Register extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {

    //Declaraçoes
    private static final String TAG ="CalendarReActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button btn_go_to_login;
    private Button btn_voltar;

    @Override //Botoes
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.registo);

        ////////////////////////////////////
         btn_go_to_login = findViewById(R.id.btn_go_to_sobre);
         btn_voltar = findViewById(R.id.btn_go_to_main);

        btn_voltar.setOnClickListener(this);
        btn_go_to_login.setOnClickListener(this);

        //Area Spinner inicio
        Spinner spinner = findViewById(R.id.aSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Distritos,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Calendario inicio
        mDisplayDate = findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year = cal.get (Calendar.YEAR);
                int month = cal.get (Calendar.MONTH);
                int day = cal.get (Calendar.DAY_OF_MONTH);

                        DatePickerDialog dialog = new DatePickerDialog(
                        Register.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: " + dayOfMonth + "/" + month + "/" + year);
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };

    }

    @Override //click
    public void onClick(View view_clicada) {
        if (view_clicada == findViewById(R.id.btn_go_to_main)){
            this.startActivity( new Intent(this,MainActivity.class));
        }
        if (view_clicada == findViewById(R.id.btn_go_to_sobre)){
            this.startActivity(new Intent(this,LogInActivity.class));
        }
    }

    @Override //spinner quando se carrega
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
