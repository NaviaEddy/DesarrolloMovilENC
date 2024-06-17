package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba_java.backend.WSacciones;
import com.example.prueba_java.backend.WSauditorias;
import com.example.prueba_java.backend.WSdocumentos;
import com.example.prueba_java.backend.WSusuarios;
import com.example.prueba_java.backend.WebServiceAPI2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WSLocalActivity extends AppCompatActivity {

    List<WSacciones> listData = new ArrayList<WSacciones>();
    List<WSdocumentos> listData2 = new ArrayList<WSdocumentos>();
    List<WSauditorias> listData3 = new ArrayList<WSauditorias>();
    List<WSusuarios> listData4 = new ArrayList<WSusuarios>();
    private TextView textViewInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wslocal);

        //getDataAcciones();
        //getDataAuditorias();
        //getDataDocumentos();
        //getDataUsuarios();

    }


    public void getDataAcciones(){
        String URL_WS = "http://127.0.0.1/webservice/primer.php/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI2 webServiceApi = retrofit.create(WebServiceAPI2.class);
        final Call<List<WSacciones>> call = webServiceApi.getAcciones();
        call.enqueue(new Callback<List<WSacciones>>() {
            @Override
            public void onResponse(Call<List<WSacciones>> call, Response<List<WSacciones>> response) {
                if(response.isSuccessful()){
                    listData = response.body();
                    StringBuilder userInfoBuilder = new StringBuilder();
                    //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();

                    // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                    for (WSacciones user : listData) {
                        userInfoBuilder.append("---------------------------------------\n");
                        userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                        userInfoBuilder.append("Accion: ").append(user.getAccion()).append("\n");
                        userInfoBuilder.append("Descripcion: ").append(user.getDescripcion()).append("\n");
                        userInfoBuilder.append("Fecha: ").append(user.getFecha()).append("\n");
                    }

                    // Mostrar la información en el TextView
                    textViewInfo.setText(userInfoBuilder.toString());
                }else{
                    Toast.makeText(WSLocalActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSacciones>> call, Throwable throwable) {

                Toast.makeText(WSLocalActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getDataAuditorias(){
        String URL_WS = "http://127.0.0.1/webservice/primer2.php/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI2 webServiceApi = retrofit.create(WebServiceAPI2.class);
        final Call<List<WSauditorias>> call = webServiceApi.getAuditorias();
        call.enqueue(new Callback<List<WSauditorias>>() {
            @Override
            public void onResponse(Call<List<WSauditorias>> call, Response<List<WSauditorias>> response) {
                if(response.isSuccessful()){
                    listData3 = response.body();
                    StringBuilder userInfoBuilder = new StringBuilder();
                    //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();

                    // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                    for (WSauditorias user : listData3) {
                        userInfoBuilder.append("---------------------------------------\n");
                        userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                        userInfoBuilder.append("Actividad: ").append(user.getActividad()).append("\n");
                        userInfoBuilder.append("Resultado: ").append(user.getResultado()).append("\n");
                        userInfoBuilder.append("Fecha: ").append(user.getFecha()).append("\n");
                    }

                    // Mostrar la información en el TextView
                    textViewInfo.setText(userInfoBuilder.toString());
                }else{
                    Toast.makeText(WSLocalActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSauditorias>> call, Throwable throwable) {

                Toast.makeText(WSLocalActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getDataDocumentos(){
        String URL_WS = "http://127.0.0.1/webservice/primer3.php/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI2 webServiceApi = retrofit.create(WebServiceAPI2.class);
        final Call<List<WSdocumentos>> call = webServiceApi.getDocumentos();
        call.enqueue(new Callback<List<WSdocumentos>>() {
            @Override
            public void onResponse(Call<List<WSdocumentos>> call, Response<List<WSdocumentos>> response) {
                if(response.isSuccessful()){
                    listData2 = response.body();
                    StringBuilder userInfoBuilder = new StringBuilder();
                    //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();

                    // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                    for (WSdocumentos user : listData2) {
                        userInfoBuilder.append("---------------------------------------\n");
                        userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                        userInfoBuilder.append("Nombre: ").append(user.getNombre()).append("\n");
                        userInfoBuilder.append("Categoria: ").append(user.getCategoria()).append("\n");
                        userInfoBuilder.append("Fecha/Creacion: ").append(user.getFechaCreacion()).append("\n");
                    }

                    // Mostrar la información en el TextView
                    textViewInfo.setText(userInfoBuilder.toString());
                }else{
                    Toast.makeText(WSLocalActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSdocumentos>> call, Throwable throwable) {

                Toast.makeText(WSLocalActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getDataUsuarios(){
        String URL_WS = "http://127.0.0.1/webservice/primer4.php/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI2 webServiceApi = retrofit.create(WebServiceAPI2.class);
        final Call<List<WSusuarios>> call = webServiceApi.getUsuarios();
        call.enqueue(new Callback<List<WSusuarios>>() {
            @Override
            public void onResponse(Call<List<WSusuarios>> call, Response<List<WSusuarios>> response) {
                if(response.isSuccessful()){
                    listData4 = response.body();
                    StringBuilder userInfoBuilder = new StringBuilder();
                    //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();

                    // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                    for (WSusuarios user : listData4) {
                        userInfoBuilder.append("---------------------------------------\n");
                        userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                        userInfoBuilder.append("Nombre: ").append(user.getNombre()).append("\n");
                        userInfoBuilder.append("Rol: ").append(user.getRol()).append("\n");
                        userInfoBuilder.append("Departamento: ").append(user.getDepartamento()).append("\n");
                    }

                    // Mostrar la información en el TextView
                    textViewInfo.setText(userInfoBuilder.toString());
                }else{
                    Toast.makeText(WSLocalActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSusuarios>> call, Throwable throwable) {

                Toast.makeText(WSLocalActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

            }
        });

    }
}