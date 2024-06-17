package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.archivo_vacio.R;

public class Main extends AppCompatActivity {

    Button buttonCalculadora, buttonGrafico, buttonCRUD, buttonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculadora = findViewById(R.id.buttonCalculadora);
        buttonGrafico = findViewById(R.id.buttonGrafico);
        buttonCRUD = findViewById(R.id.buttonCRUD);
        buttonSalir = findViewById(R.id.buttonSalir);

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonCRUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Main.this, CrudActivity.class);
                startActivity(intent1);
            }
        });

        buttonGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main.this, GraficoActivity.class);
                startActivity(intent2);
            }
        });

        buttonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        });
    }


}