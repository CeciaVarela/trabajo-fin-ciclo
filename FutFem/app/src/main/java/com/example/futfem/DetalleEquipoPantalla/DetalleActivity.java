package com.example.futfem.DetalleEquipoPantalla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.futfem.R;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;

public class DetalleActivity extends AppCompatActivity {
    private RequestQueue queue;
    private Context context = this;
    private ConstraintLayout mainLayout;
    private ProgressBar progressBar;
    private DetalleEquipoList detalles;
    private RecyclerView recyclerView;



    //Se define una constante que contiene una cadena de texto.
    public static final String CAMPO_ID_EQUIPO = "TIPO EQUIPO ID";

    //Establece los detalles que se mostrarán en el Recyclerview. Toma una instancia de DetalleEquipoList y
    //utiliza DetalleEquipoAdapter para mostrar los datos en el Recyclerview.
    public void setDetalles(DetalleEquipoList detalles) {
        this.detalles = detalles;
        DetalleEquipoAdapter myAdapter = new DetalleEquipoAdapter(this.detalles);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_equipo);
        this.queue = Volley.newRequestQueue(context);
        this.mainLayout = findViewById(R.id.main_layout);
        this.progressBar = findViewById(R.id.progress_bar);
        this.recyclerView = findViewById(R.id.recycler_view);
        requestDetalles();
    }


    private void requestDetalles() {
        int id = getIntent().getIntExtra(DetalleActivity.CAMPO_ID_EQUIPO, 1);
        progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "http://10.0.2.2:8000"+"/v1/equipos/"+id+"/",
                null,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        setDetalles(new DetalleEquipoList(response));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                if (error.networkResponse == null) {
                    Snackbar.make(mainLayout, "Connection could not be established!", Snackbar.LENGTH_SHORT).show();
                } else {

                }
            }
        });
        queue.add(request);
    }
}