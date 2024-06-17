package com.example.prueba_kotlin.backend

class WSAcciones {
    @com.google.gson.annotations.SerializedName("id")
    @com.google.gson.annotations.Expose
    private var id: Int? = null

    @com.google.gson.annotations.SerializedName("accion")
    @com.google.gson.annotations.Expose
    private var accion: String? = null

    @com.google.gson.annotations.SerializedName("descripcion")
    @com.google.gson.annotations.Expose
    private var descripcion: String? = null

    @com.google.gson.annotations.SerializedName("fecha")
    @com.google.gson.annotations.Expose
    private var fecha: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getAccion(): String? {
        return accion
    }

    fun setAccion(accion: String?) {
        this.accion = accion
    }

    fun getDescripcion(): String? {
        return descripcion
    }

    fun setDescripcion(descripcion: String?) {
        this.descripcion = descripcion
    }

    fun getFecha(): String? {
        return fecha
    }

    fun setFecha(fecha: String?) {
        this.fecha = fecha
    }
}