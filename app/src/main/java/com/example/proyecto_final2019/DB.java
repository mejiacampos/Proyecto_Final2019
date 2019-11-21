package com.example.proyecto_final2019;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "prueba", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table datos(placa text, marca text, modelo text, color text, año text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String guardar(String placa, String marca, String modelo, String color, String año, String dui, String nombre, String apellido, String telefono, String direccion) {
        String mensaje = "'";
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("placa", placa);
        contenedor.put("marca", marca);
        contenedor.put("modelo", modelo);
        contenedor.put("color", color);
        contenedor.put("año", año);
        contenedor.put("dui", dui);
        contenedor.put("nombre", nombre);
        contenedor.put("apellido", apellido);
        contenedor.put("telefono", telefono);
        contenedor.put("direccion", direccion);

        try {
            database.insertOrThrow("datos", null, contenedor);
            mensaje = "Ingresado Corectamente";
        } catch (SQLException e) {
            mensaje = "No Ingresado";
        }
        database.close();
        return mensaje;
    }

    public String[] buscar_reg(String buscar) {
        String[] datos = new String[11];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM datos WHERE placa ='" + buscar + "'";
        Cursor registros = database.rawQuery(q, null);
        if (registros.moveToNext()) {
            for (int i = 0; i < 10; i++) {
                datos[i] = registros.getString(i);
            }
            datos[10] = "Encontrado";
        } else {
            datos[10] = "No se Encontro a: " + buscar;
        }
        database.close();
        return datos;
    }

    public String eliminar(String Placa) {
        String mensaje = "'";
        SQLiteDatabase database = this.getWritableDatabase();
        int cantidad = database.delete("datos", "placa='" + Placa + "'", null);
        if (cantidad != 0) {
            mensaje = " Eliminado Correctamente";
        } else {
            mensaje = "No Existe";
        }

        database.close();
        return mensaje;
    }

    public ArrayList llenar_lv() {
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM datos";
        Cursor registros = database.rawQuery(q, null);
        if (registros.moveToFirst()) {
            do {
                lista.add(registros.getString(0));
            } while (registros.moveToNext());

        }
        database.close();
        return lista;
    }
}