package com.example.prueba_kotlin.backend

class WSUsuarios {
    @com.google.gson.annotations.SerializedName("id")
    @com.google.gson.annotations.Expose
    private var id: Int? = null

    @com.google.gson.annotations.SerializedName("nombre")
    @com.google.gson.annotations.Expose
    private var nombre: String? = null

    @com.google.gson.annotations.SerializedName("rol")
    @com.google.gson.annotations.Expose
    private var rol: String? = null

    @com.google.gson.annotations.SerializedName("departamento")
    @com.google.gson.annotations.Expose
    private var departamento: String? = null

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

    fun getRol(): String? {
        return rol
    }

    fun setRol(rol: String?) {
        this.rol = rol
    }

    fun getDepartamento(): String? {
        return departamento
    }

    fun setDepartamento(departamento: String?) {
        this.departamento = departamento
    }
}