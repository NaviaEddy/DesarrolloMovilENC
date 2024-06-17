package com.example.prueba_kotlin.backend

class operaciones(private var x: Double, private var y: Double){
    fun suma(): Double{
        return this.x + this.y
    }

    fun resta(): Double{
        return this.x - (this.y)
    }

    fun multiplicacion(): Double{
        return this.x * this.y
    }

    fun division(): String{
        if(this.y != 0.0){
            return (this.x/this.y).toString()
        }else{
            return "No se puede dividir"
        }
    }

    fun setX(num1: Double){
        this.x =  num1
    }

    fun getX(): Double{
        return this.x
    }

    fun setY(num2: Double){
        this.y =  num2
    }

    fun getY(): Double{
        return this.y
    }
}