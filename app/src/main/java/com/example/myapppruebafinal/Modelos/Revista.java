package com.example.myapppruebafinal.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private String Id;
    private String Portada;
    private String Titulo;
    private String Categoria;
    private String  Precio;
    private String Descripcion;

    public  Revista(JSONObject jsonDato) throws JSONException {
        Categoria=jsonDato.getString("category");
        Titulo=jsonDato.getString("title");
        Precio=jsonDato.getString("price");
        Descripcion=jsonDato.getString("description");
        Portada=jsonDato.getString("image");

    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            revistas.add(new Revista(datos.getJSONObject(i)));
        }
        return revistas;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPortada() {
        return Portada;
    }

    public void setPortada(String portada) {
        Portada = portada;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
