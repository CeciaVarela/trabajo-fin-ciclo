package com.example.futfem.JugadorasPantalla;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class TipoJugadoraHolder extends RecyclerView.ViewHolder {
    private TextView textNameJugadora;
    private TextView textNamePosicion;
    private ImageView imageView;

    public TipoJugadoraHolder(@NonNull View itemView){
        super(itemView);
        textNameJugadora = itemView.findViewById(R.id.textViewJugadora);
        textNamePosicion = itemView.findViewById(R.id.textViewPosicion);
        imageView = itemView.findViewById(R.id.imageViewJugadora);
    }

    public void showData(TipoJugadora jugadora){
        this.textNameJugadora.setText(jugadora.getNombreJugadora());
        this.textNamePosicion.setText(jugadora.getPosicionJugadora());
        UtilJugadoras.downloadBitmapToImageView(jugadora.getPhotoJugadora(), this.imageView);
    }
}
