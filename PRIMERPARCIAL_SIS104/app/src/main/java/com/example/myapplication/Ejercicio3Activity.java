package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ejercicio3Activity extends AppCompatActivity {

    Button buttCrear, buttMostrar, buttInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        buttCrear = findViewById(R.id.buttonCrear);
        buttInsertar = findViewById(R.id.buttonInsertar);
        buttMostrar = findViewById(R.id.buttonListar);

        buttCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ejercicio3Activity.this, CrearBDActivity.class);
                startActivity(intent);
            }
        });

        buttInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ejercicio3Activity.this, InsertarBDActivity.class);
                startActivity(intent);
            }
        });

        buttMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ejercicio3Activity.this, MostrarBDActivity.class);
                startActivity(intent);
            }
        });
    }
}