package com.example.prueba_kotlin.backend

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Color.WHITE
import android.graphics.Paint
import android.view.View

class graficos(context: Context?): View(context) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Obtener las dimensiones de la pantalla
        val screenWidth = 1080
        val screenHeight = 2040

        val squareSize = 50000.0f


        val scaleFactor =   100000

        var scaledSquareSize = squareSize

        if(squareSize <= screenWidth){
            scaledSquareSize = squareSize
        }else {
            scaledSquareSize = (screenWidth / scaleFactor) * squareSize
        }

        val squareLeft = (screenWidth - scaledSquareSize) / 2
        val squareTop = (screenHeight - scaledSquareSize) / 2


        val paint = Paint()
        paint.color = Color.CYAN
        canvas.drawRect(squareLeft, squareTop, squareLeft + scaledSquareSize, squareTop + scaledSquareSize, paint)
    }
}