package com.example.prueba_java.backend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServiceAPI {
    @GET("albums")
    Call<List<WebServiceAlbums>> getAlbums();
}
