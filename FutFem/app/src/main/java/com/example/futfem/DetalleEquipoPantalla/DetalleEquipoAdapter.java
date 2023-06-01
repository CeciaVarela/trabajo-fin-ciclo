package com.example.futfem.DetalleEquipoPantalla;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class DetalleEquipoAdapter extends RecyclerView.Adapter<DetalleEquipoHolder>{
    private DetalleEquipoList detallesToShow;

    public DetalleEquipoAdapter(DetalleEquipoList detalles){
        this.detallesToShow = detalles;
    }

    @NonNull
    @Override
    public DetalleEquipoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cellView = inflater.inflate(R.layout.activity_detalle, parent, false);
        DetalleEquipoHolder cellViewHolder = new DetalleEquipoHolder(cellView);
        return cellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleEquipoHolder holder, int position){
        DetalleEquipo dataForThisCell = this.detallesToShow.getDetalleEquipos().get(position);
        holder.showData(dataForThisCell);
    }

    @Override
    public int getItemCount(){
        return this.detallesToShow.getDetalleEquipos().size();
    }


}
