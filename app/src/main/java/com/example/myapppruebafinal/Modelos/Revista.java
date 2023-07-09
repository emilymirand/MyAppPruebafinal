package com.example.myapppruebafinal.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private String Id;
    private String Portada;
    private String Nombre;
    public  Revista(JSONObject jsonDato) throws JSONException {
        Id=jsonDato.getString("journal_id");
        Portada=jsonDato.getString("portada");
        Nombre=jsonDato.getString("name");

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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
