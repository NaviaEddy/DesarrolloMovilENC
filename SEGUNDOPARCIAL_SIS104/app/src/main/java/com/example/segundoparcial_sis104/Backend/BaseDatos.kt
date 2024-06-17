package com.example.segundoparcial_sis104.Backend

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(context: Context): SQLiteOpenHelper(context, BaseDatos.NOMBRE_BASE_DATOS, null, BaseDatos.VERSION_BASE_DATOS){

    companion object{
        private val VERSION_BASE_DATOS = 1
        private val NOMBRE_BASE_DATOS = "db_ecuacion_sis104"
        private val NOMBRE_TABLA = "puntos"
        private val ID = "id"
        private val X1 = "x1"
        private val Y1 = "y1"
        private val X2 = "x2"
        private val Y2 = "y2"
        private val Resultado = "resultado"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREAR_TABLA =
            "CREATE TABLE $NOMBRE_TABLA ($ID INTEGER PRIMARY KEY AUTOINCREMENT,$X1 FLOAT,$Y1 FLOAT,$X2 FLOAT,$Y2 FLOAT, $Resultado FLOAT);"
        db?.execSQL(CREAR_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val BORRAR_TABLA = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(BORRAR_TABLA)
        onCreate(db)
    }

    fun addResultado(d : ecuacion):Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(X1, d.x1)
        values.put(Y1, d.y1)
        values.put(X2, d.x2)
        values.put(Y2, d.y2)
        values.put(Resultado, d.d)
        val _success = db.insert(NOMBRE_TABLA,null,values)
        db.close()
        return (Integer.parseInt("$_success") != -1)
    }

    val d_result: List<ecuacion> @SuppressLint("Range")
    get(){
        val ecuacionList = ArrayList<ecuacion>()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $NOMBRE_TABLA"
        val cursor = db.rawQuery(selectQuery, null)
        if(cursor != null){
            cursor.moveToFirst()
            while(cursor.moveToNext()){
                var  ecuacion = ecuacion()
                ecuacion.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                ecuacion.x1 = cursor.getString(cursor.getColumnIndex(X1)).toFloat()
                ecuacion.y1 = cursor.getString(cursor.getColumnIndex(Y1)).toFloat()
                ecuacion.x2 =  cursor.getString(cursor.getColumnIndex(X2)).toFloat()
                ecuacion.y2 = cursor.getString(cursor.getColumnIndex(Y2)).toFloat()
                ecuacion.d = cursor.getString(cursor.getColumnIndex(Resultado)).toFloat()
                ecuacionList.add(ecuacion)
            }
        }
        cursor.close()
        return ecuacionList
    }

    /*val lugar: List<Lugares> @SuppressLint("Range")
    get(){
        val lugaresList = ArrayList<Lugares>()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $NOMBRE_TABLA"
        val cursor = db.rawQuery(selectQuery, null)
        if(cursor != null){
            cursor.moveToFirst()
            while(cursor.moveToNext()){
                val lugares = Lugares()
                lugares.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                lugares.nombre = cursor.getString(cursor.getColumnIndex(NOMBRE))
                lugares.descripcion = cursor.getString(cursor.getColumnIndex(DESCRIPCION))
                lugares.latitud = cursor.getString(cursor.getColumnIndex(LATITUD)).toFloat()
                lugares.longitud = cursor.getString(cursor.getColumnIndex(LONGITUD)).toFloat()
                lugaresList.add(lugares)
            }
        }
        cursor.close()
        return lugaresList
    }*/
}