package com.example.futfem.JugadorasPantalla;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class TipoJugadoraHolder extends RecyclerView.ViewHolder {
    private ImageView imageViewJugadora;
    private TextView textViewNombre;
    private TextView textViewPosicion;
    private TextView textViewDorsal;

    public TipoJugadoraHolder(@NonNull View itemView){
        super(itemView);
        textViewNombre = itemView.findViewById(R.id.textViewJugadora);
        textViewPosicion = itemView.findViewById(R.id.textViewPosicion);
        textViewDorsal = itemView.findViewById(R.id.textViewDorsal);
        imageViewJugadora = itemView.findViewById(R.id.imageViewJugadora);
    }


    //Mostrar los datos de una jugadora específica.
    public void showData(TipoJugadora jugadora){
        this.textViewNombre.setText(jugadora.getNombreJugadora());
        this.textViewPosicion.setText(jugadora.getPosicionJugadora());
        this.textViewDorsal.setText(jugadora.getNumeroJugadora());
        UtilJugadoras.downloadBitmapToImageView(jugadora.getPhotoJugadora(), this.imageViewJugadora);
    }
}
