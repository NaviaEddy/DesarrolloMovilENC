package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonCalculadora, buttGrafico, buttGrafico2, buttGrafico3, buttBD, buttService, buttServiceLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculadora = findViewById(R.id.buttonCalculadora);
        buttGrafico = findViewById(R.id.buttonGrafico);
        buttGrafico2 = findViewById(R.id.buttonGrafico2);
        buttGrafico3 = findViewById(R.id.buttonGrafico3);
        buttBD = findViewById(R.id.buttonBD);
        buttService = findViewById(R.id.buttonService);
        buttServiceLocal = findViewById(R.id.buttonServiceLocal);

        buttonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        });

        buttGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GraficoActivity.class);
                startActivity(intent);
            }
        });

        buttGrafico2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Grafico2Activity.class);
                startActivity(intent);
            }
        });

        buttGrafico3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsolaActivity.class);
                startActivity(intent);
            }
        });

        buttBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BaseDatosActivity.class);
                startActivity(intent);
            }
        });

        buttService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebServiceAlbumsActivity.class);
                startActivity(intent);
            }
        });

        buttServiceLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebLocalActivity.class);
                startActivity(intent);
            }
        });
    }


}