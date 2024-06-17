package com.example.prueba_kotlin.backend

class WSDocumentos {
    @com.google.gson.annotations.SerializedName("id")
    @com.google.gson.annotations.Expose
    private var id: Int? = null

    @com.google.gson.annotations.SerializedName("nombre")
    @com.google.gson.annotations.Expose
    private var nombre: String? = null

    @com.google.gson.annotations.SerializedName("categoria")
    @com.google.gson.annotations.Expose
    private var categoria: String? = null

    @com.google.gson.annotations.SerializedName("fecha_creacion")
    @com.google.gson.annotations.Expose
    private var fechaCreacion: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getNombre(): String? {
        return nombre
    }

    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }

    fun getCategoria(): String? {
        return categoria
    }

    fun setCategoria(categoria: String?) {
        this.categoria = categoria
    }

    fun getFechaCreacion(): String? {
        return fechaCreacion
    }

    fun setFechaCreacion(fechaCreacion: String?) {
        this.fechaCreacion = fechaCreacion
    }
}