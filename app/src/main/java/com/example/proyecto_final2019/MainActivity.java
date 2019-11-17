package com.example.proyecto_final2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {

    EditText Emarca, Emodelo;
    Button guardar,buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Emarca=(EditText)findViewById(R.id.marca);
        Emodelo=(EditText)findViewById(R.id.modelo);

        guardar=(Button)findViewById(R.id.guardar);
        buscar=(Button)findViewById(R.id.buscar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db= new DB(getApplicationContext(),null,null,1);
                String marca = Emarca.getText().toString();
                String modelo = Emodelo.getText().toString();
                String mensaje =db.guardar(marca, modelo);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });