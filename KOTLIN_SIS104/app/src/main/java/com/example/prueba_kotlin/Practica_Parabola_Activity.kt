package com.example.prueba_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba_kotlin.backend.Parabola
import com.example.prueba_kotlin.backend.graficos

class Practica_Parabola_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_practica_parabola)
        setContentView(Parabola(this))
    }
}