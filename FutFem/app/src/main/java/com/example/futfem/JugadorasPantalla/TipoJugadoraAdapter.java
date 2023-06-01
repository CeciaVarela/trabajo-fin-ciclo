package com.example.futfem.JugadorasPantalla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class TipoJugadoraAdapter extends RecyclerView.Adapter<TipoJugadoraHolder> {
    private TipoJugadoraList jugadorasToShow;

    public TipoJugadoraAdapter(TipoJugadoraList jugadoras){
        this.jugadorasToShow = jugadoras;
    }

    @NonNull
    @Override
    public TipoJugadoraHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cellView = inflater.inflate(R.layout.activity_jugadoras, parent, false);
        TipoJugadoraHolder cellViewHolder = new TipoJugadoraHolder(cellView);
        return cellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TipoJugadoraHolder holder, int position){
        TipoJugadora dataForThisCell = this.jugadorasToShow.getJugadoras().get(position);
        holder.showData(dataForThisCell);
    }

    @Override
    public int getItemCount(){
        return this.jugadorasToShow.getJugadoras().size();
    }
}
