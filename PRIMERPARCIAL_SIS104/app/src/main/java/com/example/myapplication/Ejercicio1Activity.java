package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.MathContext;
import java.math.RoundingMode;

public class Ejercicio1Activity extends AppCompatActivity {

    EditText editTextK;
    TextView textViewResultado;

    Button buttCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        editTextK = findViewById(R.id.EditTextK);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttCalcular = findViewById(R.id.buttonCalcular);

        buttCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el valor de k del EditText
                String kString = editTextK.getText().toString();
                // Verificar si el EditText no está vacío
                if (!kString.isEmpty()) {
                    // Convertir el valor de k a entero
                    int k = Integer.parseInt(kString);
                    // Calcular el valor de Pi usando el método calcularPl() con el valor de k
                    double piValue = calcularPl(k);
                    // Mostrar el valor de Pi en el TextView
                    textViewResultado.setText(String.valueOf(piValue));
                    //Toast.makeText(Ejercicio1Activity.this, "El valor de Pi es: " + k, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static double calcularPl(int maxK) {
        double sum = 0;
        for (int k = 0; k <= maxK; k++) {
            double term = 1;
            term *= Math.pow(2, 0.5); // 2√2
            term *= factorial(4 * k); // (4k)!
            term *= (1103 + 26390 * k);
            term /= Math.pow(9801, k); // 9801^k
            term /= factorial(k); // k!
            term /= factorial(4 * k); // (4k)!
            sum += term;
        }
        return 1 / sum;
    }




    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= (long) i;
        }
        return result;
    }
}