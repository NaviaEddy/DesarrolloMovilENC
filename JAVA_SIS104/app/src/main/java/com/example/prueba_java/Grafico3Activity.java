package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.prueba_java.backend.grafico;
import com.example.prueba_java.backend.grafico3;

public class Grafico3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_grafico3);
        setContentView(new grafico3(Grafico3Activity.this));
    }
}