package com.example.prueba_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.prueba_kotlin.backend.operaciones

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val editTextA = findViewById<EditText>(R.id.EditTextA)
        val editTextB = findViewById<EditText>(R.id.EditTextB)
        val butSuma = findViewById<Button>(R.id.buttonSuma)
        val butResta = findViewById<Button>(R.id.buttonResta)
        val butMultiplicacion = findViewById<Button>(R.id.buttonMultiplicacion)
        val butDivision = findViewById<Button>(R.id.buttonDivision)
        val butIgual = findViewById<Button>(R.id.buttonIgual)
        val buttonsalircal = findViewById<Button>(R.id.buttonSalirCalc)
        val butDel = findViewById<Button>(R.id.buttonDel)
        val num0 = findViewById<Button>(R.id.buttonNum0)
        val num1 = findViewById<Button>(R.id.buttonNum1)
        val num2 = findViewById<Button>(R.id.buttonNum2)
        val num3 = findViewById<Button>(R.id.buttonNum3)
        val num4 = findViewById<Button>(R.id.buttonNum4)
        val num5 = findViewById<Button>(R.id.buttonNum5)
        val num6 = findViewById<Button>(R.id.buttonNum6)
        val num7 = findViewById<Button>(R.id.buttonNum7)
        val num8 = findViewById<Button>(R.id.buttonNum8)
        val num9 = findViewById<Button>(R.id.buttonNum9)
        val memoria = ArrayList<Double>()

        num0.setOnClickListener {
            val text = num0.text.toString()
            if(editTextA.equals("")){
                editTextA.append(text)
            }else{
                editTextA.append(memoria[0].toString())
            }
        }

        num1.setOnClickListener {
            val text = num1.text.toString()
            editTextA.append(text)
        }

        num2.setOnClickListener {
            val text = num2.text.toString()
            editTextA.append(text)
        }

        num3.setOnClickListener {
            val text = num3.text.toString()
            editTextA.append(text)
        }

        num4.setOnClickListener {
            val text = num4.text.toString()
            editTextA.append(text)
        }

        num5.setOnClickListener {
            val text = num5.text.toString()
            editTextA.append(text)
        }

        num6.setOnClickListener {
            val text = num6.text.toString()
            editTextA.append(text)
        }

        num7.setOnClickListener {
            val text = num7.text.toString()
            editTextA.append(text)
        }

        num8.setOnClickListener {
            val text = num8.text.toString()
            editTextA.append(text)
        }

        num9.setOnClickListener {
            val text = num9.text.toString()
            editTextA.append(text)
        }

        butSuma.setOnClickListener {
            val op = butSuma.text.toString()
            if(editTextB.text.toString().equals("Resultado")){
                editTextA.append(op)
            }else{
                editTextA.text.clear()
                editTextA.append(editTextB.text.toString() + op)
                editTextB.setText("Resultado")
            }
        }

        butResta.setOnClickListener {
            val op = butResta.text.toString()
            if(editTextB.text.toString().equals("Resultado")){
                editTextA.append(op)
            }else{
                editTextA.text.clear()
                editTextA.append(editTextB.text.toString() + op)
                editTextB.setText("Resultado")
            }
        }

        butMultiplicacion.setOnClickListener {
            val op = butMultiplicacion.text.toString()
            editTextA.append(op)
            if(editTextB.text.toString().equals("Resultado")){
                editTextA.append(op)
            }else{
                editTextA.text.clear()
                editTextA.append(editTextB.text.toString() + op)
                editTextB.setText("Resultado")
            }
        }

        butDivision.setOnClickListener {
            val op = butDivision.text.toString()
            editTextA.append(op)
            if(editTextB.text.toString().equals("Resultado")){
                editTextA.append(op)
            }else{
                editTextA.text.clear()
                editTextA.append(editTextB.text.toString() + op)
                editTextB.setText("Resultado")
            }
        }

        butIgual.setOnClickListener {
            val textOp = editTextA.text.toString()
            editTextB.text.clear()
            if(textOp.contains('+')){
                val op = textOp.split("+")
                val Operaciones = operaciones(op[0].toDouble(), op[1].toDouble())
                val result = Operaciones.suma()
                editTextB.setText(result.toString())
            }
            if(textOp.contains('-')){
                val op = textOp.split("-")
                val Operaciones = operaciones(op[0].toDouble(), op[1].toDouble())
                val result = Operaciones.resta()
                editTextB.setText(result.toString())
            }
            if(textOp.contains('*')){
                val op = textOp.split("*")
                val Operaciones = operaciones(op[0].toDouble(), op[1].toDouble())
                val result = Operaciones.multiplicacion()
                editTextB.setText(result.toString())
            }
            if(textOp.contains('/')){
                val op = textOp.split("/")
                val Operaciones = operaciones(op[0].toDouble(), op[1].toDouble())
                val result = Operaciones.division()
                editTextB.setText(result)
            }
        }

        butDel.setOnClickListener {
            editTextA.text.clear()
            editTextB.text.clear()
            editTextB.setText("Resultado")
        }

        buttonsalircal.setOnClickListener{
            finish()
        }
    }
}