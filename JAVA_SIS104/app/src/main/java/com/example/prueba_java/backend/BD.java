package com.example.prueba_java.backend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {

    private String sql_create = "CREATE TABLE personas(id INTEGER PRIMARY KEY AUTOINCREMENT, paterno VARCHAR(40), materno VARCHAR(40), nombre VARCHAR(40));";
    private String sql_drop = "DROP TABLE IF EXISTS personas;";

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
