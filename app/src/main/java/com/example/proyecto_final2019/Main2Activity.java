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

//main2

public class Main2Activity extends AppCompatActivity {
    EditText Ebuscar;
    TextView placa, marca, modelo, color, año, dui, nombre, apellido, telefono, direccion;
    Button Bbuscar,BEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        placa=(TextView)findViewById(R.id.placa);
        marca=(TextView)findViewById(R.id.marca);
        modelo=(TextView)findViewById(R.id.modelo);
        color=(TextView)findViewById(R.id.color);
        año=(TextView)findViewById(R.id.año);
        dui=(TextView)findViewById(R.id.dui);
        nombre=(TextView)findViewById(R.id.nombre);
        apellido=(TextView)findViewById(R.id.apellido);
        telefono=(TextView)findViewById(R.id.telefono);
        direccion=(TextView)findViewById(R.id.direccion);
        Ebuscar=(EditText)findViewById(R.id.Ebuscar);
        Bbuscar=(Button)findViewById(R.id.Bbuscar);
        BEliminar=(Button)findViewById(R.id.BEliminar);
        nplaca=(EditText)findViewById(R.id.NPlaca);
        nmarca=(EditText)findViewById(R.id.NMarca);
        nmodelo=(EditText)findViewById(R.id.NModelo);
        ncolor=(EditText)findViewById(R.id.NColor);
        naño=(EditText)findViewById(R.id.NAño);
        BActualizar=(Button)findViewById(R.id.BActualizar);
        Bbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(getApplicationContext(),null,null,1);
                String buscar = Ebuscar.getText().toString();
                String[] datos;
                datos=db.buscar_reg(buscar);
                placa.setText(datos[0]);
                marca.setText(datos[1]);
                modelo.setText(datos[2]);
                color.setText(datos[3]);
                año.setText(datos[4]);
                dui.setText(datos[5]);
                nombre.setText(datos[6]);
                apellido.setText(datos[7]);
                telefono.setText(datos[8]);
                direccion.setText(datos[9]);
                Toast.makeText(getApplicationContext(),datos[10],Toast.LENGTH_SHORT).show();
            }
        });
        BEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(getApplicationContext(),null,null,1);
                String Placa = placa.getText().toString();
                String mensaje =db.eliminar(Placa);
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
