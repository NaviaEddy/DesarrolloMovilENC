package com.example.prueba_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba_java.backend.BD;

public class BaseDatosActivity extends AppCompatActivity {

    Button buttCrear, buttMostrar, buttUpdate, buttDelete, buttSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);


        buttCrear = findViewById(R.id.buttonCrear);
        buttMostrar = findViewById(R.id.buttonMostrar);
        buttDelete = findViewById(R.id.buttonDelete);
        buttSalir = findViewById(R.id.buttonSalir);

        buttCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseDatosActivity.this, CrearBDActivity.class);
                startActivity(intent);
            }
        });

        buttMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseDatosActivity.this, MostrarBDActivity.class);
                startActivity(intent);
            }
        });

        buttSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}