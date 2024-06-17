package com.example.prueba_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.prueba_kotlin.backend.BaseDatos
import com.example.prueba_kotlin.backend.Lugares

class InsertarCrudActivity : AppCompatActivity() {

    var dbHandler: BaseDatos? = null
    var listTasks: List<Lugares> = ArrayList<Lugares>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_crud)

        dbHandler = BaseDatos(this)

        val buttonGuardarCrud = findViewById<Button>(R.id.buttonGuardarCrud)
        val editextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editextDescripcion = findViewById<EditText>(R.id.editTextDescripcion)
        val editextLongitud = findViewById<EditText>(R.id.editTextLongitud)
        val editextLatitud = findViewById<EditText>(R.id.editTextLatitud)


        buttonGuardarCrud.setOnClickListener {
            // Obtener los valores de los EditText
            val nombre = editextNombre.text.toString()
            val descripcion = editextDescripcion.text.toString()
            val latitud = editextLatitud.text.toString().toFloatOrNull() ?: 0.0f
            val longitud = editextLongitud.text.toString().toFloatOrNull() ?: 0.0f

            // Crear un objeto Lugares con los valores
            val lugares = Lugares()
            lugares.nombre = nombre
            lugares.descripcion = descripcion
            lugares.latitud = latitud
            lugares.longitud = longitud

            // Insertar en la base de datos
            val success = dbHandler?.addLugar(lugares) ?: false

            // Mostrar un mensaje Toast
            // Mostrar un mensaje Toast
            val mensaje = if (success) {
                editextNombre.text.clear()
                editextDescripcion.text.clear()
                editextLatitud.text.clear()
                editextLongitud.text.clear()
                "Inserción exitosa"
            } else {
                "Error al insertar"
            }
            Toast.makeText(this@InsertarCrudActivity, mensaje, Toast.LENGTH_SHORT).show()
            Log.d("Insertar", "--->$mensaje")
        }
    }
}