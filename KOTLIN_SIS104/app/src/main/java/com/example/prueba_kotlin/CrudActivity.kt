package com.example.prueba_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.prueba_kotlin.backend.BaseDatos
import com.example.prueba_kotlin.backend.Lugares

class CrudActivity : AppCompatActivity() {

    var dbHandler: BaseDatos? = null
    var listTasks: List<Lugares> = ArrayList<Lugares>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        val buttonSalirCrud = findViewById<Button>(R.id.buttonSalirCrud)
        val buttonInsertarCrud = findViewById<Button>(R.id.buttonCrudCrear)
        val buttonMostrarCrud = findViewById<Button>(R.id.buttonCrudMostrar)
        val buttonActualizarCrud = findViewById<Button>(R.id.buttonCrudActualizar)
        val buttonEliminarCrud = findViewById<Button>(R.id.buttonCrudEliminar)


        dbHandler = BaseDatos(this)
        var success: Boolean = false
        val lugares: Lugares = Lugares()
        lugares.nombre = "nombre1"
        lugares.descripcion = "descripcion1"
        lugares.latitud = 1.3f
        lugares.longitud = 2.4f
        success = dbHandler?.addLugar(lugares) as Boolean

        Log.d("Datos","--->" + success.toString())

        success = false
        val lugares1: Lugares = Lugares()
        lugares1.nombre = "nombre2"
        lugares1.descripcion = "descripcion2"
        lugares1.latitud = 1.3f
        lugares1.longitud = 2.4f
        success = dbHandler?.addLugar(lugares1) as Boolean

        listTasks = (dbHandler as BaseDatos).lugar

        Log.d("Datos","--->" + listTasks[0].nombre)
        for(lugares in listTasks){
            Log.d("Datos","--->" + lugares.nombre)
        }

        success = false
        val lugares2: Lugares = Lugares()
        lugares2.id = 1 //Voy a actualizar este registro
        lugares2.nombre = "nombreX"
        lugares2.descripcion = "descripcionX"
        lugares2.latitud = 1.3f
        lugares2.longitud = 2.4f
        success = dbHandler?.updateLugar(lugares2) as Boolean

        success = false
        success = dbHandler?.deleteLugar(1) as Boolean

        listTasks = (dbHandler as BaseDatos).lugar
        Log.d("Datos","--->" + listTasks)


        buttonInsertarCrud.setOnClickListener {
            val intent = Intent(this@CrudActivity,InsertarCrudActivity::class.java)
            startActivity(intent)
        }

        buttonMostrarCrud.setOnClickListener {
            val intent = Intent(this@CrudActivity,MostrarCrudActivity::class.java)
            startActivity(intent)
        }

        buttonSalirCrud.setOnClickListener {
            finish()
        }
    }
}