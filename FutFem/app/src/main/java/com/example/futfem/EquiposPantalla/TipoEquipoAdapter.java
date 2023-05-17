package com.example.futfem.EquiposPantalla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class TipoEquipoAdapter extends RecyclerView.Adapter<TipoEquipoHolder> {
    private TipoEquipoList equiposToShow;

    public TipoEquipoAdapter(TipoEquipoList equipos){
        this.equiposToShow = equipos;
    }

    @NonNull
    @Override
    public TipoEquipoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cellView = inflater.inflate(R.layout.equipos_recycler_cell, parent, false);
        TipoEquipoHolder cellViewHolder = new TipoEquipoHolder(cellView);
        return cellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TipoEquipoHolder holder, int position){
        TipoEquipo dataForThisCell = this.equiposToShow.getEquipos().get(position);
        holder.showData(dataForThisCell);
    }

    @Override
    public int getItemCount(){
        return this.equiposToShow.getEquipos().size();
    }
}
