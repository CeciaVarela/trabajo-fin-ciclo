package com.example.futfem.DetalleEquipoPantalla;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.R;

public class DetalleEquipoHolder extends RecyclerView.ViewHolder{
    private ImageView imageViewCampo;
    private ImageView imageViewEscudo;
    private TextView textNombreEquipo;
    private TextView textNombreEstadio;
    private TextView textAnoFundacion;
    private TextView textEntrenador;

    private TextView textEstadioLinear;
    private TextView textAnoLinear;
    private TextView textEntrenadorLinear;

    public DetalleEquipoHolder(@NonNull View itemView){
        super(itemView);
        imageViewCampo = itemView.findViewById(R.id.imagenCampo);
        imageViewEscudo = itemView.findViewById(R.id.imagenEscudo);
        textNombreEquipo = itemView.findViewById(R.id.nombreEquipo);
        textNombreEstadio = itemView.findViewById(R.id.nombreEstadio);
        textAnoFundacion = itemView.findViewById(R.id.anoFundacion);
        textEntrenador = itemView.findViewById(R.id.entrenador);
        textEstadioLinear = itemView.findViewById(R.id.nombreEstadioLinear);
        textAnoLinear = itemView.findViewById(R.id.anoFundacionLinear);
        textEntrenadorLinear = itemView.findViewById(R.id.entrenadorLinear);

        AppCompatButton botonJugadoras = itemView.findViewById(R.id.botonJugadoras);

        botonJugadoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, JugadorasActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public void showData(DetalleEquipo detalleEquipo) {
        this.textNombreEquipo.setText(detalleEquipo.getNombreEquipo());
        this.textNombreEstadio.setText(detalleEquipo.getEstadio());
        this.textAnoFundacion.setText(detalleEquipo.getAnoFundacion());
        this.textEntrenador.setText(detalleEquipo.getEntrenador());
        UtilDetalle.downloadBitmapToImageView(detalleEquipo.getPhotoEstadio(), this.imageViewCampo);
        UtilDetalle.downloadBitmapToImageView(detalleEquipo.getPhotoEscudo(), this.imageViewEscudo);
    }
}
