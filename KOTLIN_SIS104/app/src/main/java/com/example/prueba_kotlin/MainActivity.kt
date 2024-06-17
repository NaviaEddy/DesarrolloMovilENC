package com.example.prueba_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prueba_kotlin.backend.BaseDatos
import com.example.prueba_kotlin.backend.Lugares
import com.example.prueba_kotlin.backend.operaciones

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttoncalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val buttonsalir = findViewById<Button>(R.id.buttonSalir)
        val buttoncrud = findViewById<Button>(R.id.buttonCrud)
        val buttongrafico = findViewById<Button>(R.id.buttonGrafico)
        val buttonparabola = findViewById<Button>(R.id.buttonParabola)
        val buttoncaratula = findViewById<Button>(R.id.buttonCaratula)
        val buttonsw = findViewById<Button>(R.id.buttonServiceWeb)

        buttonsalir.setOnClickListener{
            finish()
        }

        buttoncalculadora.setOnClickListener{
            val intent = Intent(this@MainActivity,CalculadoraActivity::class.java)
            startActivity(intent)
        }

        buttongrafico.setOnClickListener{
            val intent1 = Intent(this@MainActivity,GraficoActivity::class.java)
            startActivity(intent1)
        }

        buttoncrud.setOnClickListener{
            val intent2 = Intent(this@MainActivity,CrudActivity::class.java)
            startActivity(intent2)
        }

        buttonparabola.setOnClickListener {
            val intent3 = Intent(this@MainActivity,Practica_Parabola_Activity::class.java)
            startActivity(intent3)
        }

        buttoncaratula.setOnClickListener {
            val intent4 = Intent(this@MainActivity,CaratulaActivity::class.java)
            startActivity(intent4)
        }

        buttonsw.setOnClickListener {
            val intent5 = Intent(this@MainActivity,WS_Local_Activity::class.java)
            startActivity(intent5)
        }
    }
}