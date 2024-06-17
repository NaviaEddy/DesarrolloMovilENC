package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Backend.BD;

public class InsertarBDActivity extends AppCompatActivity {

    BD basedatos;
    SQLiteDatabase db;

    String SQL;

    EditText nombre, descripcion, stock, preciounitario;

    Button buttGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_bd);

        nombre = findViewById(R.id.EdittextNombre);
        descripcion = findViewById(R.id.EdittextDescripcion);
        stock = findViewById(R.id.EdittextStock);
        preciounitario = findViewById(R.id.EdittextUnitario);
        buttGuardar = findViewById(R.id.buttonGuardarBD);

        basedatos = new BD(InsertarBDActivity.this, "BDacademicos", null, 1);

        db = basedatos.getWritableDatabase();
        buttGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nombre = nombre.getText().toString();
                String Descripcion = descripcion.getText().toString();
                String Stock = stock.getText().toString();
                String Unitario = preciounitario.getText().toString();
                SQL = "INSERT INTO producto(nombre, descripcion, stock, preciounitario) VALUES('" + Nombre + "', '" + Descripcion + "', '" + Stock + "');";

                try {
                    db.execSQL(SQL);
                    // Si la inserción es exitosa, muestra un mensaje de éxito.
                    Toast.makeText(getApplicationContext(), "Inserción exitosa", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    // Si hay un error, muestra un mensaje de error.
                    Toast.makeText(getApplicationContext(), "Error al insertar los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}