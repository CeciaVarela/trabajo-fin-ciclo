package com.example.futfem.DetalleEquipoPantalla;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.EquiposPantalla.TipoEquipo;
import com.example.futfem.EquiposPantalla.UtilEquipos;
import com.example.futfem.R;

public class TipoDetalleEquipoHolder extends RecyclerView.ViewHolder{
    public ImageView imageViewEstadio;
    private ImageView imageviewEscudo;
    private TextView textNameTitulo;
    private TextView textViewEstadio;
    private TextView textViewAnoFundacion;
    private TextView textViewEntrenador;

    public TipoDetalleEquipoHolder(@NonNull View itemView){
        super(itemView);
        imageViewEstadio = itemView.findViewById(R.id.imagenEstadio);
        imageviewEscudo = itemView.findViewById(R.id.imagenEscudo);
        textNameTitulo = itemView.findViewById(R.id.titulo);
        textViewEstadio = itemView.findViewById(R.id.nombreEstadio);
        textViewAnoFundacion = itemView.findViewById(R.id.anoFundacion);
        textViewEntrenador = itemView.findViewById(R.id.entrenador);
        /*itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetalleEquipo.class);
                context.startActivity(intent);
            }
        });*/
    }

    public void showData(TipoDetalleEquipo equipo) {
        this.textNameTitulo.setText(equipo.getNombreEquipo());
        this.textViewEstadio.setText(equipo.getEstadio());
        this.textViewAnoFundacion.setText(equipo.getAnoFundacion());
        this.textViewEntrenador.setText(equipo.getEntrenador());
        UtilDetalleEquipos.downloadBitmapToImageView(equipo.getPhotoEstadio(), this.imageViewEstadio);
        UtilDetalleEquipos.downloadBitmapToImageView(equipo.getPhotoEscudo(), this.imageviewEscudo);
    }
}
