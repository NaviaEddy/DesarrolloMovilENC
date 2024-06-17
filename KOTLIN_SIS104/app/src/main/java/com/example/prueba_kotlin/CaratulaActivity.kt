package com.example.prueba_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba_kotlin.backend.caratula
import com.example.prueba_kotlin.backend.graficos

class CaratulaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_caratula)
        setContentView(caratula(this))
    }
}