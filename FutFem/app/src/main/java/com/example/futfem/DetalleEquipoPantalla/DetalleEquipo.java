package com.example.futfem.DetalleEquipoPantalla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.futfem.R;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;

public class DetalleEquipo extends AppCompatActivity {

    private RequestQueue queue;
    private Context context = this;
    private ConstraintLayout mainLayout;
    private FrameLayout frameLayout;
    private TipoDetalleEquipoList detalle;
    private RelativeLayout relativeLayout;
    private LinearLayout linearLayout;

    public static final String CAMPO_NOMBRE_SITIO = "TIPO EQUIPO NOMBRE";
    public static final String CAMPO_ID_DETALLE = "TIPO EQUIPO ID";

    public void setLugares(TipoDetalleEquipoList detalle) {
        this.detalle = detalle;
        TipoDetalleAdapter myAdapter = new TipoDetalleAdapter(this.detalle);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_equipo);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.queue = Volley.newRequestQueue(context);
        //this.mainLayout = findViewById(R.id.main_layout);
        this.frameLayout = findViewById(R.id.frameFotos);
        //this.relativeLayout = findViewById(R.id.relativeLayout);
        this.linearLayout = findViewById(R.id.linearDatos);
        String nombre = getIntent().getStringExtra(CAMPO_NOMBRE_SITIO);
        setTitle(nombre);
        requestSitiosInteres();
    }


    private void requestSitiosInteres() {
        int id = getIntent().getIntExtra(DetalleEquipo.CAMPO_ID_DETALLE, 1);
        //progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "http://10.0.2.2:8000" + "/v1/equipos/"+id+"/detalle",
                null,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        //progressBar.setVisibility(View.INVISIBLE);
                        setLugares(new TipoDetalleEquipoList(response));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //progressBar.setVisibility(View.INVISIBLE);
                if (error.networkResponse == null) {
                    Snackbar.make(mainLayout, "Connection could not be established!", Snackbar.LENGTH_SHORT).show();
                } else {

                }
            }
        });
        queue.add(request);
    }

}