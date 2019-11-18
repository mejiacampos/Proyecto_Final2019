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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Eplaca, Emarca, Emodelo, Ecolor, Eaño, Edui, Enombre, Eapellido, Etelefono, Edireccion;
    Button guardar,buscar;
//diego
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Eplaca=(EditText)findViewById(R.id.placa);
        Emarca=(EditText)findViewById(R.id.marca);
        Emodelo=(EditText)findViewById(R.id.modelo);
        Ecolor=(EditText)findViewById(R.id.color);
        Eaño=(EditText)findViewById(R.id.año);
        Edui=(EditText)findViewById(R.id.dui);
        Enombre=(EditText)findViewById(R.id.nombre);
        Eapellido=(EditText)findViewById(R.id.apellido);
        Etelefono=(EditText)findViewById(R.id.telefono);
        Edireccion=(EditText)findViewById(R.id.direccion);
        guardar=(Button)findViewById(R.id.guardar);
        buscar=(Button)findViewById(R.id.buscar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db= new DB(getApplicationContext(),null,null,1);
                String placa = Eplaca.getText().toString();
                String marca = Emarca.getText().toString();
                String modelo = Emodelo.getText().toString();
                String color = Ecolor.getText().toString();
                String año = Eaño.getText().toString();
                String dui = Edui.getText().toString();
                String nombre = Enombre.getText().toString();
                String apellido = Eapellido.getText().toString();
                String telefono = Etelefono.getText().toString();
                String direccion = Edireccion.getText().toString();
                String mensaje =db.guardar(placa, marca, modelo, color, año, dui, nombre, apellido, telefono, direccion);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intento);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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