package com.example.prueba_java.backend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServiceAPI2 {
    @GET("acciones")
    Call<List<WSacciones>> getAcciones();

    @GET("auditorias")
    Call<List<WSauditorias>> getAuditorias();

    @GET("documentos")
    Call<List<WSdocumentos>> getDocumentos();

    @GET("usuarios")
    Call<List<WSusuarios>> getUsuarios();
}
