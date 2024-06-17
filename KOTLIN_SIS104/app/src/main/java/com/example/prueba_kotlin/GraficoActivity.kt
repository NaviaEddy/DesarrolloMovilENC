package com.example.prueba_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prueba_kotlin.backend.graficos

class GraficoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_grafico)
        setContentView(graficos(this))

        /*val buttonSalirGrafico = findViewById<Button>(R.id.buttonSalirGraf)
        buttonSalirGrafico.setOnClickListener {
            finish()
        }*/
    }
}