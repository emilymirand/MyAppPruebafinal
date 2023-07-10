package com.example.myapppruebafinal.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapppruebafinal.Modelos.Revista;
import com.example.myapppruebafinal.R;

import java.util.ArrayList;

public class AdaptadorRevista extends ArrayAdapter<Revista> {
    public AdaptadorRevista(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.lyitemrevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);
        TextView lblcategoria = (TextView)item.findViewById(R.id.categoria1);lblcategoria.setText(getItem(position).getCategoria());
        TextView lblTitulo = (TextView)item.findViewById(R.id.titulo);lblTitulo.setText(getItem(position).getTitulo());
        TextView lblPrecio = (TextView)item.findViewById(R.id.precio1);lblPrecio.setText(getItem(position).getPrecio());
        TextView lblDescripcion = (TextView)item.findViewById(R.id.descripcion);lblDescripcion.setText(getItem(position).getTitulo());
        ImageView imageView = (ImageView)item.findViewById(R.id.portada);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);
        return(item);
    }
}