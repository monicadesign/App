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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Classes.Cliente;

import java.util.Calendar;

public class Register extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {

    //Declaraçoes
    private static final String TAG ="CalendarReActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button btn_go_to_login;
    private Button btn_voltar;

    private EditText caixaNomeEscrito;
    private EditText caixaApelidoEscrito;
    private EditText caixaContctoEscrito;
    private EditText caixaEmailEscrito;
    private String date;

    //ClienteExemplo
    private Cliente clienteCriado;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.registo);

        ////////////////////////////////////
         btn_go_to_login = findViewById(R.id.btn_go_to_sobre);
         btn_voltar = findViewById(R.id.btn_go_to_main);

        caixaNomeEscrito = findViewById(R.id.NomeReg);
        caixaApelidoEscrito = findViewById(R.id.ApelidoReg);
        caixaContctoEscrito = findViewById(R.id.ContactoReg);
        caixaEmailEscrito = findViewById(R.id.EmailReg);

        btn_voltar.setOnClickListener(this);
        btn_go_to_login.setOnClickListener(this);

        //clienteCriado = new Cliente("Mónica", "monicavieira_m@gmail.com",965444232);

        //region Area Spinner inicio
        Spinner spinner = findViewById(R.id.aSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Distritos,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //endregion


        //region Calendario
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
                date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        //endregion

    }

    @Override //click
    public void onClick(View view_clicada) {
        if (view_clicada == findViewById(R.id.btn_go_to_main)){
            this.startActivity( new Intent(this,MainActivity.class));
        }
        if (view_clicada == findViewById(R.id.btn_go_to_sobre)){
            this.startActivity(new Intent(this,LogInActivity.class));
            //novo cliente
            /*clienteCriado = new Cliente(caixaNomeEscrito.getText().toString(),
                                        caixaEmailEscrito.getText().toString(),
                                        123456789);
            clienteCriado.setDataDeNascimento(date);
            Log.i("CLIENTE", "O cliente é " + clienteCriado.getNome() + clienteCriado.getEmail() + clienteCriado.getContacto() + "       " + clienteCriado.getDataDeNascimento());
        */
        }
    }

    @Override //spinner quando se carrega
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (position == 0)
            ((TextView)parent.getChildAt(0)).setTextColor(getColor(R.color.appcolor3));
        }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
