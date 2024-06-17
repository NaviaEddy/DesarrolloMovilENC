package com.example.prueba_kotlin.backend

class WSAuditoria {
    @com.google.gson.annotations.SerializedName("id")
    @com.google.gson.annotations.Expose
    private var id: Int? = null

    @com.google.gson.annotations.SerializedName("fecha")
    @com.google.gson.annotations.Expose
    private var fecha: String? = null

    @com.google.gson.annotations.SerializedName("actividad")
    @com.google.gson.annotations.Expose
    private var actividad: String? = null

    @com.google.gson.annotations.SerializedName("resultado")
    @com.google.gson.annotations.Expose
    private var resultado: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getFecha(): String? {
        return fecha
    }

    fun setFecha(fecha: String?) {
        this.fecha = fecha
    }

    fun getActividad(): String? {
        return actividad
    }

    fun setActividad(actividad: String?) {
        this.actividad = actividad
    }

    fun getResultado(): String? {
        return resultado
    }

    fun setResultado(resultado: String?) {
        this.resultado = resultado
    }
}