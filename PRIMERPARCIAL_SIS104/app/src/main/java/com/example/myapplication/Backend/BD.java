package com.example.myapplication.Backend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class BD extends SQLiteOpenHelper {
    private String sql_create = "CREATE TABLE productos(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(40), descripcion VARCHAR(40), stock INT, preciounitario FLOAT);";
    private String sql_drop = "DROP TABLE IF EXISTS productos;";

    public BD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sql_drop);
        db.execSQL(sql_create);
    }
}
