package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba_java.backend.BD;

public class CrearBDActivity extends AppCompatActivity {

    BD basedatos;
    SQLiteDatabase db;

    EditText paterno, materno, nombre;

    Button buttGuardar, buttSalirCrearBD;

    String SQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bd);

        paterno =  findViewById(R.id.editTextPaterno);
        materno = findViewById(R.id.editTextMaterno);
        nombre = findViewById(R.id.editTextNombre);
        buttGuardar = findViewById(R.id.buttonGuardar);
        buttSalirCrearBD = findViewById(R.id.buttonSalirCrear);

        basedatos = new BD(CrearBDActivity.this, "BDacademicos", null, 1);

        db = basedatos.getWritableDatabase();
        buttGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Paterno = paterno.getText().toString();
                String Materno = materno.getText().toString();
                String Nombre = nombre.getText().toString();
                SQL = "INSERT INTO personas(paterno, materno, nombre) VALUES('" + Paterno + "', '" + Materno + "', '" + Nombre + "');";

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

        buttSalirCrearBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}