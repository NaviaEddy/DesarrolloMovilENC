package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.prueba_java.backend.WebServiceAPI;
import com.example.prueba_java.backend.WebServiceAlbums;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceAlbumsActivity extends AppCompatActivity {

    List<WebServiceAlbums> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_albums);

        GetData();
    }

    public void GetData(){

        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create()).build();

        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WebServiceAlbums>> call = webServiceApi.getAlbums();
        call.enqueue(new Callback<List<WebServiceAlbums>>() {
            @Override
            public void onResponse(Call<List<WebServiceAlbums>> call, Response<List<WebServiceAlbums>> response) {
                if(response.isSuccessful()){
                    listData = response.body();
                    Toast.makeText(WebServiceAlbumsActivity.this, listData.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WebServiceAlbumsActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();}
            }

            @Override
            public void onFailure(Call<List<WebServiceAlbums>> call, Throwable throwable) {
                Toast.makeText(WebServiceAlbumsActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }
}