package com.example.futfem.DetalleEquipoPantalla;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.EquiposPantalla.TipoEquipo;
import com.example.futfem.EquiposPantalla.TipoEquipoHolder;
import com.example.futfem.EquiposPantalla.TipoEquipoList;
import com.example.futfem.R;

import java.util.List;

public class TipoDetalleAdapter extends RecyclerView.Adapter<TipoDetalleEquipoHolder> {

    private TipoDetalleEquipoList equiposToShow;

    public TipoDetalleAdapter(TipoDetalleEquipoList equipos){
        this.equiposToShow = equipos;
    }

    @NonNull
    @Override
    public TipoDetalleEquipoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cellView = inflater.inflate(R.layout.equipos_recycler_cell, parent, false);
        TipoDetalleEquipoHolder cellViewHolder = new TipoDetalleEquipoHolder(cellView);
        return cellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TipoDetalleEquipoHolder holder, int position){
        TipoDetalleEquipo dataForThisCell = this.equiposToShow.getDetalleEquipos().get(position);
        holder.showData(dataForThisCell);
        holder.imageViewEstadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetalleEquipo.class);
                intent.putExtra(DetalleEquipo.CAMPO_ID_DETALLE, dataForThisCell.getId());
                view.getContext().startActivity(intent);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return this.equiposToShow.getDetalleEquipos().size();
    }
}
