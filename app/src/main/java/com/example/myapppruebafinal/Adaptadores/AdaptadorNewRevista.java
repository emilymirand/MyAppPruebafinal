package com.example.myapppruebafinal.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapppruebafinal.Modelos.NewRevista;
import com.example.myapppruebafinal.R;

import java.util.ArrayList;

public class AdaptadorNewRevista extends ArrayAdapter<NewRevista> {
    public AdaptadorNewRevista(Context context, ArrayList<NewRevista> informacion){
        super(context, R.layout.lyitemnewrevista, informacion);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemnewrevista, null);
        TextView lbltitulo = (TextView)item.findViewById(R.id.titulo);
        lbltitulo.setText(getItem(position).getTitulo());
        TextView lblfecha = (TextView)item.findViewById(R.id.fecha);
        lblfecha.setText(getItem(position).getFecha());
        TextView lblvolumen = (TextView)item.findViewById(R.id.volumen);
        lblvolumen.setText(getItem(position).getVolumen());
        ImageView imageView = (ImageView)item.findViewById(R.id.portada);
        Glide.with(this.getContext())
                .load(getItem(position).getCover())
                .into(imageView);
        return(item);
    }
}
