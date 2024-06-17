package com.example.prueba_kotlin.backend

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class caratula (context: Context?) : View(context) {

    private val ingText = "Ing. en Ciencias de la Computación"
    private val sisText = "SIS104"
    private val semestreText = "Semestre 01/24"
    private val encText = "ENC"

    val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.WHITE
        paint.textSize = 40f

        // Dibuja el título "Ing. en Ciencias de la Computación"
        canvas.drawText(ingText, 100f, 100f, paint)

        // Dibuja el curso "SIS104"
        canvas.drawText(sisText, 100f, 200f, paint)

        // Dibuja el semestre "Semestre 01/24"
        canvas.drawText(semestreText, 100f, 300f, paint)

// Tamaño del cubo
        val size = 200f

        // Centro del cubo
        val centerX = width / 2f
        val centerY = height / 2f

        // Dibuja las líneas del cubo
        drawCube(canvas, centerX, centerY, size)
    }

    private fun drawCube(canvas: Canvas, centerX: Float, centerY: Float, size: Float) {
        // Calcula las coordenadas de los vértices de la cara frontal del cubo
        val frontTopLeftX = centerX - size / 2
        val frontTopLeftY = centerY - size / 2
        val frontTopRightX = centerX + size / 2
        val frontTopRightY = centerY - size / 2
        val frontBottomLeftX = centerX - size / 2
        val frontBottomLeftY = centerY + size / 2
        val frontBottomRightX = centerX + size / 2
        val frontBottomRightY = centerY + size / 2

        // Calcula las coordenadas de los vértices de la cara trasera del cubo (más a la izquierda y arriba, mismo tamaño)
        val backTopLeftX = centerX - size * 0.75f
        val backTopLeftY = centerY - size * 0.75f
        val backTopRightX = centerX - size * 0.25f
        val backTopRightY = centerY - size * 0.75f
        val backBottomLeftX = centerX - size * 0.75f
        val backBottomLeftY = centerY - size * 0.25f
        val backBottomRightX = centerX - size * 0.25f
        val backBottomRightY = centerY - size * 0.25f

        // Dibuja la cara frontal
        drawFace(canvas, frontTopLeftX, frontTopLeftY, frontTopRightX, frontTopRightY, frontBottomRightX, frontBottomRightY, frontBottomLeftX, frontBottomLeftY, Color.BLUE)

        drawFace(canvas, frontTopLeftX, frontTopLeftY, backTopLeftX, backTopLeftY, backBottomLeftX, backBottomLeftY, frontBottomLeftX, frontBottomLeftY, Color.RED) // LATERAL INFERIOR
        drawFace(canvas, frontTopLeftX, frontTopLeftY, frontTopRightX, frontTopRightY, backTopRightX, backTopRightY, backTopLeftX, backTopLeftY, Color.GREEN) // LATERAL IZQUIERDO
        drawFace(canvas, frontTopRightX, frontTopRightY, frontBottomRightX, frontBottomRightY, backBottomRightX, backBottomRightY, backTopRightX, backTopRightY, Color.YELLOW) // LATERAL DERECHO
        drawFace(canvas, backTopLeftX, backTopLeftY, backTopRightX, backTopRightY, backBottomRightX, backBottomRightY, backBottomLeftX, backBottomLeftY, Color.MAGENTA) // LATERAL SUPERIOR


        // Dibuja la cara trasera
        drawFace(canvas, backTopLeftX, backTopLeftY, backTopRightX, backTopRightY, backBottomRightX, backBottomRightY, backBottomLeftX, backBottomLeftY, Color.CYAN)

        // Dibuja las líneas
        drawLine(canvas, frontTopLeftX, frontTopLeftY, frontTopRightX, frontTopRightY) //LINEA TOP
        drawLine(canvas, frontTopRightX, frontTopRightY, frontBottomRightX, frontBottomRightY) //LINEA RIGHT
        drawLine(canvas, frontBottomRightX, frontBottomRightY, frontBottomLeftX, frontBottomLeftY) //LINEA LEFT
        drawLine(canvas, frontBottomLeftX, frontBottomLeftY, frontTopLeftX, frontTopLeftY) //LINEA BOTTOM

        drawLine(canvas, backTopLeftX, backTopLeftY, backTopRightX, backTopRightY)
        drawLine(canvas, backTopRightX, backTopRightY, backBottomRightX, backBottomRightY)
        drawLine(canvas, backBottomRightX, backBottomRightY, backBottomLeftX, backBottomLeftY)
        drawLine(canvas, backBottomLeftX, backBottomLeftY, backTopLeftX, backTopLeftY)

        drawLine(canvas, frontTopLeftX, frontTopLeftY, backTopLeftX, backTopLeftY) //ESQUINA SUP IZQUIERDA
        drawLine(canvas, frontTopRightX, frontTopRightY, backTopRightX, backTopRightY) //ESQUINA SUP DERECHA
        drawLine(canvas, frontBottomLeftX, frontBottomLeftY, backBottomLeftX, backBottomLeftY) //ESQUINA INF IZQUIERDA
        drawLine(canvas, frontBottomRightX, frontBottomRightY, backBottomRightX, backBottomRightY) //ESQUINA INF DERECHA
    }

    private fun drawFace(canvas: Canvas, x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float, x4: Float, y4: Float, color: Int) {
        paint.color = color
        paint.style = Paint.Style.FILL
        val path = Path()
        path.moveTo(x1, y1)
        path.lineTo(x2, y2)
        path.lineTo(x3, y3)
        path.lineTo(x4, y4)
        path.lineTo(x1, y1)
        path.close()
        canvas.drawPath(path, paint)
    }

    private fun drawLine(canvas: Canvas, startX: Float, startY: Float, endX: Float, endY: Float) {
        paint.color = Color.WHITE
        paint.strokeWidth = 2f
        canvas.drawLine(startX, startY, endX, endY, paint)
    }




}