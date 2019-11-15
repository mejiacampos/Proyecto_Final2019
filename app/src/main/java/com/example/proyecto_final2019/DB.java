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

    public String guardar(String placa, String marca, String modelo, String color, String año) {
        String mensaje = "'";
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("placa", placa);
        contenedor.put("marca", marca);
        contenedor.put("modelo", modelo);
        contenedor.put("color", color);
        contenedor.put("año", año);

        try {
            database.insertOrThrow("datos", null, contenedor);
            mensaje = "Ingresado Corectamente";
        } catch (SQLException e) {
            mensaje = "No Ingresado";
        }
        database.close();
        return mensaje;
    }