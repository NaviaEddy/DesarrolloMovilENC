package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button buttEjer1, buttEjer2, buttEjer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttEjer1 = findViewById(R.id.buttonEjer1);
        buttEjer2 = findViewById(R.id.buttonEjer2);
        buttEjer3 = findViewById(R.id.buttonEjer3);

        buttEjer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, Ejercicio1Activity.class);
                startActivity(intent);
            }
        });

        buttEjer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, Ejercicio2Activity.class);
                startActivity(intent);
            }
        });

        buttEjer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, Ejercicio3Activity.class);
                startActivity(intent);
            }
        });



    }
}