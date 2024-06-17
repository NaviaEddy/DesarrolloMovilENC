package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.prueba_java.backend.grafico;

public class GraficoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_grafico);
        setContentView(new grafico(GraficoActivity.this));

    }


}