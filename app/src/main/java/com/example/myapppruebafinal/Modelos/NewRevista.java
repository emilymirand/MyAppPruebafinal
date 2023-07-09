package com.example.myapppruebafinal.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewRevista {
    private String cover;
    private String fecha;
    private String titulo;
    private String volumen;


    public NewRevista(JSONObject a) throws JSONException {
        cover = a.getString("cover").toString();
        fecha = a.getString("date_published").toString() ;
        titulo = a.getString("title").toString() ;
        volumen = a.getString("volume").toString() ;

    }
    public static ArrayList<NewRevista> JsonObjectsBuild(JSONArray informacion) throws JSONException {
        ArrayList<NewRevista> libros = new ArrayList<>();
        for (int i = 0; i < informacion.length() && i<20; i++) {
            libros.add(new NewRevista(informacion.getJSONObject(i)));
        }
        return libros;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }
}
