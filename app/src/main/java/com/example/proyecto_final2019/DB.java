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
        super(context, "prueba", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table datos(marca text, modelo text, color text, año text, precio text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String guardar(String marca, String modelo){
        String mensaje="'";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("marca",marca);
        contenedor.put("modelo",modelo);
        try {
            database.insertOrThrow("datos",null,contenedor);
            mensaje="Ingresado Correctamente";
        }catch (SQLException e) {
            mensaje="No Ingresado";
        }


        return mensaje;
    }
}
    public String[] buscar_reg(String buscar){
        String[] datos= new String[3];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM datos WHERE marca ='"+buscar+"'";
        Cursor registros = database.rawQuery(q,null);
        if (registros.moveToFirst()) {
            for (int i = 0; i<2;i++){
                datos[i]= registros.getString(i);
            }
            datos[2]= "Encontrado";
        }else {
            datos[2]= "No se Encontro a "+buscar;
        }
        database.close();
        return datos;
    }
    public String eliminar(String Marca){
        String mensaje ="";
        SQLiteDatabase database = this.getWritableDatabase();
        int cantidad =database.delete("datos","marca='"+Marca+"'",null);
        if (cantidad !=0){
            mensaje="Eliminado Correctamente";
        }else {
            mensaje = "No Existe";
        }
        database.close();
        return mensaje;
    }
    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM datos";
        Cursor registros = database.rawQuery(q,null);
        if (registros.moveToFirst()){
            do {
                lista.add(registros.getString(0));
            }while (registros.moveToNext());
        }

        return lista;
    }
}