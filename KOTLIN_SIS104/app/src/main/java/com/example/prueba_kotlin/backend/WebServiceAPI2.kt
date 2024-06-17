package com.example.prueba_kotlin.backend


import io.reactivex.Observable
import retrofit2.http.GET

interface WebServiceAPI2 {

    @GET("primer.php")
    fun getAccionesObservable(): Observable<Map<String, WSAcciones>>

    @GET("primer2.php")
    fun getAuditoriasObservable(): Observable<Map<String, WSAuditoria>>

    @GET("primer3.php")
    fun getDocumentosObservable(): Observable<Map<String, WSDocumentos>>

    @GET("primer4.php")
    fun getUsuariosObservable(): Observable<Map<String, WSUsuarios>>

    /*@GET("primer.php")
    fun getAccionesObservable(): Observable<List<WSAcciones>>

    @GET("primer2.php")
    fun getAuditoriasObservable(): Observable<List<WSAuditoria>>

    @GET("primer3.php")
    fun getDocumentosObservable(): Observable<List<WSDocumentos>>

    @GET("primer4.php")
    fun getUsuariosObservable(): Observable<List<WSUsuarios>>*/
}