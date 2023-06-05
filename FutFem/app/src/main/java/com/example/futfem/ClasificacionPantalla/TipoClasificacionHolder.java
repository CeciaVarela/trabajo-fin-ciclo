package com.example.futfem.ClasificacionPantalla;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class TipoClasificacionHolder extends RecyclerView.ViewHolder{
    private TextView textViewNombreEquipo;
    private TextView textViewPuntos;
    private TextView textViewJugados;
    private TextView textViewGanados;
    private TextView textViewEmpatados;
    private TextView textViewPerdidos;
    private TextView textViewAFavor;
    private TextView textViewEnContra;

    public TipoClasificacionHolder(@NonNull View itemView){
        super(itemView);
        textViewNombreEquipo = itemView.findViewById(R.id.nombreEquipoClasificacion);
        textViewPuntos = itemView.findViewById(R.id.cantidadPuntos);
        textViewJugados = itemView.findViewById(R.id.cantidadJugados);
        textViewGanados = itemView.findViewById(R.id.cantidadGanados);
        textViewEmpatados = itemView.findViewById(R.id.cantidadEmpatados);
        textViewPerdidos = itemView.findViewById(R.id.cantidadPerdidos);
        textViewAFavor = itemView.findViewById(R.id.cantidadGolesfavor);
        textViewEnContra = itemView.findViewById(R.id.textViewEnContra);
    }

    public void showData(TipoClasificacion clasificacion){
        this.textViewNombreEquipo.setText(clasificacion.getNombreEquipo());
        this.textViewPuntos.setText(clasificacion.getPoints());
        this.textViewJugados.setText(clasificacion.getPartidosJugador());
        this.textViewGanados.setText(clasificacion.getPartidosGanados());
        this.textViewEmpatados.setText(clasificacion.getPartidosEmpatados());
        this.textViewPerdidos.setText(clasificacion.getPartidosPerdidos());
        this.textViewAFavor.setText(clasificacion.getGolesFavor());
        this.textViewEnContra.setText(clasificacion.getGolesContra());
    }
}
