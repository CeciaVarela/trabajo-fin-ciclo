package com.example.futfem.ClasificacionPantalla;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class ClasificacionFragment extends Fragment {
    private RequestQueue queue;
    private Context context;
    private ConstraintLayout mainLayout;
    private ProgressBar progressBar;
    private TipoClasificacionList clasificaciones;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.clasificacion_recycler_cell,container, false);
        return view;
    }

    public void setClasificaciones(TipoClasificacionList clasificaciones) {
        this.clasificaciones = clasificaciones;
        TipoClasificacionAdapter myAdapter = new TipoClasificacionAdapter(this.clasificaciones);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public TipoClasificacionList getClasificaciones() {
        return clasificaciones;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        this.queue = Volley.newRequestQueue(view.getContext());
        this.mainLayout = view.findViewById(R.id.main_layout_clasificacion);
        this.progressBar = view.findViewById(R.id.progressBar);
        this.recyclerView = view.findViewById(R.id.recyclerview);

        requestClasificacion();
    }

    private void requestClasificacion(){
        progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "http://10.0.2.2:8000"+"/v1/clasificacion",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        setClasificaciones(new TipoClasificacionList(response));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                if(error.networkResponse == null){
                    Snackbar.make(mainLayout, "Connection could not be established!", Snackbar.LENGTH_SHORT).show();
                }else{
                    int serverCode = error.networkResponse.statusCode;
                    Snackbar.make(mainLayout, "Server responded with " + serverCode, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        queue.add(request);
    }

}