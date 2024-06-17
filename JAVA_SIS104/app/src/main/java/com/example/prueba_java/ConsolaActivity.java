package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.prueba_java.backend.grafico2;
import com.example.prueba_java.backend.grafico_consola;

public class ConsolaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_consola);
        setContentView(new grafico_consola(ConsolaActivity.this));
    }
}