package com.example.prueba_java.backend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSauditorias {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("actividad")
    @Expose
    private String actividad;
    @SerializedName("resultado")
    @Expose
    private String resultado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
