package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.prueba_java.backend.grafico2;

public class Grafico2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_grafico2);
        setContentView(new grafico2(Grafico2Activity.this));
    }
}