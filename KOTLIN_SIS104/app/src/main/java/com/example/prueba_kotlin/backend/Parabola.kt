package com.example.prueba_kotlin.backend

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class Parabola (context: Context?) : View(context) {
    private val TAG = "Grafico"
    private val TAG1 = "Y"
    private val TAG2 = "Xt"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.BLACK)
        val paint = Paint()
        paint.color = Color.WHITE
        val ancho = canvas.width
        val alto = canvas.height
        Log.d(TAG, "ancho:" + ancho + "alto:" + alto)
        canvas.drawLine(0f, (alto / 2).toFloat(), ancho.toFloat(), (alto / 2).toFloat(), paint)
        canvas.drawLine((ancho / 2).toFloat(), 0f, (ancho / 2).toFloat(), alto.toFloat(), paint)
        canvas.drawLine(ancho.toFloat(), 0f, 0f, alto.toFloat(), paint)
        var j = 0f
        while (j <= 10) {
            val limitInfX = -20 + j
            val limitSupX = 20 + j
            val LimitInfY = -20 + j
            val LimitSupY = 20 + j
            var x = limitInfX
            while (x <= limitSupX) {
                val Y = fx(x)
                val xt = ((x - limitInfX) / (limitSupX - limitInfX) * ancho).toDouble()
                val yt = alto - (Y - LimitInfY) / (LimitSupY - LimitInfY) * alto
                //ouble zt = ((x - limitInfZ) / (limitSupZ - limitInfZ)) * ancho;
                paint.color = Color.YELLOW
                canvas.drawCircle(xt.toFloat(), yt.toFloat(), 3f, paint)
                x += 0.1.toFloat()
            }
            j += 0.03.toFloat()
        }
    }

    fun fx(x: Float): Double {
        return (x * x).toDouble()
    }

}