package com.micky.primerkotlin.backend

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Color.WHITE
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager

@Suppress("DEPRECATION")
class Grafico(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(WHITE)
        var paint = Paint()
        paint.color = Color.BLUE
        canvas.drawCircle(100.0f, 100.0f, 50.0f, paint)

        val escala = 0.00001

        val tamanoPantalla = TPantalla()
        val ancho = tamanoPantalla.first
        val alto = tamanoPantalla.second

        paint.color = Color.BLACK
        paint.textSize = 50.0f
        canvas.drawText("Ancho: $ancho px, Alto: $alto px", 10.0f, 200.0f, paint)
        canvas.drawText("Factor de escala: $escala px", 10.0f, 250.0f, paint)

        val tamañoCuadradoAbsoluto = 500.0f
        val tamañoCuadrado = if (tamañoCuadradoAbsoluto > ancho) {
            ancho*tamañoCuadradoAbsoluto* escala.toFloat()
        } else {
            tamañoCuadradoAbsoluto

        }
        canvas.drawText("tamaño: $tamañoCuadrado cuadrado px", 10.0f, 300.0f, paint)
        paint.color = Color.RED
        val xCuadrado = (ancho - tamañoCuadrado) / 2.0f
        val yCuadrado = 200.0f
        canvas.drawRect(xCuadrado, yCuadrado, xCuadrado + tamañoCuadrado, yCuadrado + tamañoCuadrado, paint)

    }

    fun TPantalla(): Pair<Int, Int> {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()

        // Obtener las métricas de la pantalla actual
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        // Obtener el ancho y alto de la pantalla en píxeles
        val ancho = displayMetrics.widthPixels
        val alto = displayMetrics.heightPixels

        return Pair(ancho, alto)
    }
}
