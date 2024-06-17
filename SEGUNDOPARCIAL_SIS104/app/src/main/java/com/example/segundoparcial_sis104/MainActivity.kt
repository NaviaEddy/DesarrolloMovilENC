package com.example.segundoparcial_sis104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttMostrarPuntos = findViewById<Button>(R.id.buttonMostrarPuntos)
        val buttSalir = findViewById<Button>(R.id.buttonSalir)

        buttMostrarPuntos.setOnClickListener {
            val intent = Intent(this@MainActivity, SqlActivity::class.java)
            startActivity(intent)
        }

        buttSalir.setOnClickListener {
            finish()
        }

    }
}