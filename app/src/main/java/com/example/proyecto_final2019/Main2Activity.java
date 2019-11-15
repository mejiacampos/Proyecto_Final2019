package com.example.proyecto_final2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    //HOLA SOY BRAYAN EDUARDO, HOLA DIEGO**

    EditText Ebuscar;
    TextView marca, modelo;
    Button Bbuscar,BEliminar;

    //HOLA SOY BRAYAN EDUARDO, HOLA DIEGO**


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        marca=(TextView)findViewById(R.id.marca);
        modelo=(TextView)findViewById(R.id.modelo);
        Ebuscar=(EditText)findViewById(R.id.Ebuscar);
        Bbuscar=(Button)findViewById(R.id.Bbuscar);
        BEliminar=(Button)findViewById(R.id.BEliminar);
        Bbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(getApplicationContext(),null,null,1);
                String buscar = Ebuscar.getText().toString();
                String[] datos;
                datos=db.buscar_reg(buscar);
                marca.setText(datos[0]);
                modelo.setText(datos[1]);
                Toast.makeText(getApplicationContext(),datos[2],Toast.LENGTH_SHORT).show();
            }
        });
        BEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(getApplicationContext(),null,null,1);
                String Marca = marca.getText().toString();
                String mensaje =db.eliminar(Marca);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settins) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}