package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba_java.backend.BD;

import java.util.ArrayList;
import java.util.List;

public class MostrarBDActivity extends AppCompatActivity {

    BD basedatos;
    SQLiteDatabase db;

    TextView textViewPersonas;

    String SQL;

    Button buttSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_bd);

        buttSalir = findViewById(R.id.buttonSalirMostrarBD);

        SQL = "SELECT * FROM personas;";
        basedatos = new BD(MostrarBDActivity.this, "BDacademicos", null, 1);
        db = basedatos.getReadableDatabase();

        // Encuentra el TextView donde mostrarás los datos
        textViewPersonas = findViewById(R.id.persona_item_textview);

        mostrarDatos();

        buttSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void mostrarDatos() {
        String SQL = "SELECT * FROM personas;";
        Cursor cursor = db.rawQuery(SQL, null);
        StringBuilder builder = new StringBuilder();

        if (cursor.moveToFirst()) {
            do {
                int paternoIndex = cursor.getColumnIndex("paterno");
                int maternoIndex = cursor.getColumnIndex("materno");
                int nombreIndex = cursor.getColumnIndex("nombre");

                String paterno = cursor.getString(paternoIndex);
                String materno = cursor.getString(maternoIndex);
                String nombre = cursor.getString(nombreIndex);

                builder.append("Paterno: ").append(paterno)
                        .append(" Materno: ").append(materno)
                        .append(" Nombre: ").append(nombre)
                        .append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Mostrar los datos en el TextView
        textViewPersonas.setText(builder.toString());
    }




}