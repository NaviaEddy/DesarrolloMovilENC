package com.example.segundoparcial_sis104.Backend

import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    @GET("puntos.php")
    fun getpuntos(): Call<Map<String, WSPuntos>>
}