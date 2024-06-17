package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba_java.backend.operaciones;

public class CalculadoraActivity extends AppCompatActivity {
    EditText edidtxtA, edidtxtB;
    Button buttonSuma, buttonResta, buttonMultiplicacion, buttonDivision, buttonSalirCalc,
            num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        edidtxtA = findViewById(R.id.edidTextA);
        edidtxtB = findViewById(R.id.edidTextB);
        buttonSuma = findViewById(R.id.buttonS);
        buttonResta = findViewById(R.id.buttonR);
        buttonMultiplicacion = findViewById(R.id.buttonM);
        buttonDivision = findViewById(R.id.buttonD);
        buttonSalirCalc = findViewById(R.id.buttonSalirCalc);
        num1 = findViewById(R.id.buttonNum1);
        num2 = findViewById(R.id.buttonNum2);
        num3 = findViewById(R.id.buttonNum3);
        num4 = findViewById(R.id.buttonNum4);
        num5 = findViewById(R.id.buttonNum5);
        num6 = findViewById(R.id.buttonNum6);
        num7 = findViewById(R.id.buttonNum7);
        num8 = findViewById(R.id.buttonNum8);
        num9 = findViewById(R.id.buttonNum9);
        num0 = findViewById(R.id.buttonNum0);


        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int x = Integer.parseInt(edidtxtA.getText().toString());
                int y = Integer.parseInt(edidtxtB.getText().toString());
                operaciones Operaciones = new operaciones(x, y);
                Toast.makeText(CalculadoraActivity.this,"La suma es: " + Operaciones.suma(),Toast.LENGTH_LONG).show();*/
                String text = buttonSuma.getText().toString();
                edidtxtA.append(text);
            }
        });

        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(edidtxtA.getText().toString());
                int y = Integer.parseInt(edidtxtB.getText().toString());
                operaciones Operaciones = new operaciones(x, y);
                Toast.makeText(CalculadoraActivity.this,"La resta es: " + Operaciones.resta(),Toast.LENGTH_LONG).show();
            }
        });

        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(edidtxtA.getText().toString());
                int y = Integer.parseInt(edidtxtB.getText().toString());
                operaciones Operaciones = new operaciones(x, y);
                Toast.makeText(CalculadoraActivity.this,"La multiplicacion es: " + Operaciones.multiplicacion(),Toast.LENGTH_LONG).show();
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int x = Integer.parseInt(edidtxtA.getText().toString());
                //int y = Integer.parseInt(edidtxtB.getText().toString());
                operaciones Operaciones = new operaciones(Integer.parseInt(edidtxtA.getText().toString()), Integer.parseInt(edidtxtB.getText().toString()));
                Toast.makeText(CalculadoraActivity.this,"La division es: " + Operaciones.division(),Toast.LENGTH_LONG).show();
            }
        });

        buttonSalirCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num1.getText().toString();
                edidtxtA.append(text);
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num2.getText().toString();
                edidtxtA.append(text);
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num3.getText().toString();
                edidtxtA.append(text);
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num4.getText().toString();
                edidtxtA.append(text);
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num5.getText().toString();
                edidtxtA.append(text);
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num6.getText().toString();
                edidtxtA.append(text);
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num7.getText().toString();
                edidtxtA.append(text);
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num8.getText().toString();
                edidtxtA.append(text);
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num9.getText().toString();
                edidtxtA.append(text);
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num0.getText().toString();
                edidtxtA.append(text);
            }
        });


    }


}