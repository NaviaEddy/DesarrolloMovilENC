package com.example.prueba_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.prueba_java.backend.WSacciones;
import com.example.prueba_java.backend.WSauditorias;
import com.example.prueba_java.backend.WSdocumentos;
import com.example.prueba_java.backend.WSusuarios;

import java.util.ArrayList;
import java.util.List;

public class WebLocalActivity extends AppCompatActivity {

    List<WSacciones> listData = new ArrayList<WSacciones>();
    List<WSdocumentos> listData2 = new ArrayList<WSdocumentos>();
    List<WSauditorias> listData3 = new ArrayList<WSauditorias>();
    List<WSusuarios> listData4 = new ArrayList<WSusuarios>();
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_local);
    }
}