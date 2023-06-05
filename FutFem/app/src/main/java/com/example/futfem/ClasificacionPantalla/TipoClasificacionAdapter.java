package com.example.futfem.ClasificacionPantalla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class TipoClasificacionAdapter extends RecyclerView.Adapter<TipoClasificacionHolder> {
    private TipoClasificacionList clasificacionToShow;

    public TipoClasificacionAdapter(TipoClasificacionList clasificaciones){
        this.clasificacionToShow = clasificaciones;
    }

    @NonNull
    @Override
    public TipoClasificacionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cellView = inflater.inflate(R.layout.fragment_clasificacion, parent, false);
        TipoClasificacionHolder cellViewHolder = new TipoClasificacionHolder(cellView);
        return cellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TipoClasificacionHolder holder, int position){
        TipoClasificacion dataForThisCell = this.clasificacionToShow.getClasificaciones().get(position);
        holder.showData(dataForThisCell);
    }

    @Override
    public int getItemCount(){
        return this.clasificacionToShow.getClasificaciones().size();
    }
}
