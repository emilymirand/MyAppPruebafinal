package com.example.myapppruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myapppruebafinal.Adaptadores.AdaptadorNewRevista;
import com.example.myapppruebafinal.Modelos.NewRevista;
import com.example.myapppruebafinal.WebServer.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivityEdicion extends AppCompatActivity implements com.example.myapplication.WebService.Asynchtask {
    private ListView ListOpc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edicion);
        Bundle bundle  = this.getIntent().getExtras();
        ListOpc = (ListView)findViewById(R.id.lista_libros);
        View header = getLayoutInflater().inflate(R.layout.lyitemheader,null);
        ListOpc.addHeaderView(header);
        int a = bundle.getInt("ID");
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=" + a;
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(url, datos, MainActivityEdicion.this, MainActivityEdicion.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<NewRevista> lstUsuarios = NewRevista.JsonObjectsBuild(jsonArray);
        AdaptadorNewRevista adaptadorNewRevista = new AdaptadorNewRevista(this, lstUsuarios);
        ListOpc.setAdapter(adaptadorNewRevista);

    }

}