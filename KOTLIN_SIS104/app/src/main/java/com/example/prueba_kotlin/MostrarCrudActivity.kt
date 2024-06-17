package com.example.prueba_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.prueba_kotlin.backend.BaseDatos
import com.example.prueba_kotlin.backend.Lugares



class MostrarCrudActivity : AppCompatActivity() {

    var dbHandler: BaseDatos? = null
    var listTasks: List<Lugares> = ArrayList<Lugares>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_crud)

        dbHandler = BaseDatos(this)

        val textmostrar = findViewById<TextView>(R.id.textViewMostrarCrud)

        listTasks = (dbHandler as BaseDatos).lugar

        val stringBuilder = StringBuilder()

        for (lugares in listTasks) {
            stringBuilder.append("Nombre: ${lugares.nombre}\n")
            stringBuilder.append("Descripción: ${lugares.descripcion}\n")
            stringBuilder.append("Latitud: ${lugares.latitud}\n")
            stringBuilder.append("Longitud: ${lugares.longitud}\n\n")
        }

        textmostrar.setText(stringBuilder.toString())
    }
}