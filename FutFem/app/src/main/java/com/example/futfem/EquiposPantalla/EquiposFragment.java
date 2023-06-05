package com.example.futfem.EquiposPantalla;

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

public class EquiposFragment extends Fragment {
    private RequestQueue queue;
    private Context context;
    private ConstraintLayout mainLayout;
    private ProgressBar progressBar;
    private TipoEquipoList equipos;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipos,container, false);
        return view;
    }

    //Establece los equipos que se mostrarán en el Recyclerview. Toma una instancia de TipoEquipolist y
    // utiliza TipoEquipoAdapter para mostrar los datos en el Recyclerview.
    public void setEquipos(TipoEquipoList equipos){
        this.equipos = equipos;
        TipoEquipoAdapter myAdapter = new TipoEquipoAdapter(this.equipos);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        this.queue = Volley.newRequestQueue(view.getContext());
        this.mainLayout = view.findViewById(R.id.main_layout);
        this.progressBar = view.findViewById(R.id.progressBar);
        this.recyclerView = view.findViewById(R.id.recyclerview);

        requestEquipos();
    }

    public TipoEquipoList getEquipos() {
        return equipos;
    }

    private void requestEquipos(){
        progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "http://10.0.2.2:8000"+"/v1/equipos",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        //Snackbar.make(mainLayout, "Clips received", Snackbar.LENGTH_SHORT).show();
                        setEquipos(new TipoEquipoList(response));
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