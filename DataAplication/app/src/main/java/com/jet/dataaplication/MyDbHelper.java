package com.jet.dataaplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final int DATABSE_VERSION =1;
    private static final String DATABSE_NAME ="areas.db";

    public MyDbHelper(@Nullable Context context){
        super(context, DATABSE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table area (id INTEGER PRIMARY KEY, nombre TEXT, poblacion INTEGER, latitud REAL, longitud REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists area");
        onCreate(db);
    }

    public void insertArea(SQLiteDatabase db, Area area){
        ContentValues values = new ContentValues();

        values.put("id", area.getId());
        values.put("nombre", area.getName());
        values.put("poblacion", area.getPoblacion());
        values.put("latitud", area.getLatitud());
        values.put("longitud", area.getLongitud());

        db.insert("area", null, values);
    }

    public ArrayList<Area> selectCity(SQLiteDatabase db) {
        ArrayList<Area> cities = new ArrayList<Area>();
        Cursor filas = db.rawQuery("select * from area", null);
        if (filas.moveToFirst()) {
            do {
                Area city = new Area(filas.getInt(0), filas.getString(1), filas.getInt(2),
                        filas.getDouble(3),filas.getDouble(4));
                cities.add(city);
            } while (filas.moveToNext());
        }
        return cities;
    }

}
