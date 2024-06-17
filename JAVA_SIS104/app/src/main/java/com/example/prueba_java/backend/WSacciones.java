package com.example.prueba_java.backend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSacciones {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("accion")
        @Expose
        private String accion;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("fecha")
        @Expose
        private String fecha;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAccion() {
            return accion;
        }

        public void setAccion(String accion) {
            this.accion = accion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

}
