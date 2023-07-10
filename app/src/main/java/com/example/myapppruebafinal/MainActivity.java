package com.example.myapppruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapppruebafinal.Adaptadores.AdaptadorRevista;
import com.example.myapppruebafinal.Modelos.Revista;
import com.example.myapppruebafinal.WebServer.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements com.example.myapplication.WebService.Asynchtask, AdapterView.OnItemClickListener {
    private ListView ListOpc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListOpc=findViewById(R.id.LstListaRevista);
        View header = getLayoutInflater().inflate(R.layout.lyitemheader, null);
        ListOpc.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://fakestoreapi.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
        //ListOpc.setOnItemClickListener(this);

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONListarevista =new JSONArray(result);

        ArrayList<Revista> lstrevista =Revista.JsonObjectsBuild(JSONListarevista);
//adaptador
        AdaptadorRevista adaptadorRevista=new AdaptadorRevista(MainActivity.this,lstrevista);
        ListOpc.setAdapter(adaptadorRevista);
        //inicializacion del evento onclick
        ListOpc.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Revista revistaSeleccionada = (Revista) parent.getItemAtPosition(position);

        Intent intent = new Intent(MainActivity.this, MainActivityEdicion.class);
        intent.putExtra("categoria", revistaSeleccionada.getCategoria());
        intent.putExtra("titulo", revistaSeleccionada.getTitulo());
        intent.putExtra("precio", revistaSeleccionada.getPrecio());
        intent.putExtra("imagenUrl", revistaSeleccionada.getPortada());
        startActivity(intent);

    }
}