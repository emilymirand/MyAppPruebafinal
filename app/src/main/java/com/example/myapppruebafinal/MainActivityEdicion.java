package com.example.myapppruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapppruebafinal.Modelos.Revista;
import com.example.myapppruebafinal.WebServer.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivityEdicion extends AppCompatActivity  {
    private ListView ListOpc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edicion);

        String categoria = getIntent().getStringExtra("categoria");
        String titulo = getIntent().getStringExtra("titulo");
        String precio = getIntent().getStringExtra("precio");
        String imagenUrl = getIntent().getStringExtra("imagenUrl");

        TextView txtCategoria = findViewById(R.id.category);
        txtCategoria.setText(categoria);

        TextView txtTitulo = findViewById(R.id.titulo1);
        txtTitulo.setText(titulo);

        TextView txtPrecio = findViewById(R.id.pagar);
        txtPrecio.setText(String.valueOf(precio));

        ImageView imageView = findViewById(R.id.Portada1);
        Glide.with(this).load(imagenUrl).into(imageView);
    }
}






