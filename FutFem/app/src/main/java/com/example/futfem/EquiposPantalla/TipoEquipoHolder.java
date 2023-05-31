package com.example.futfem.EquiposPantalla;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.DetalleEquipoPantalla.DetalleEquipo;
import com.example.futfem.DetalleEquipoPantalla.TipoDetalleEquipo;
import com.example.futfem.JugadorasPantalla.JugadorasActivity;
import com.example.futfem.JugadorasPantalla.TipoJugadora;
import com.example.futfem.R;

public class TipoEquipoHolder extends RecyclerView.ViewHolder{
    private TextView textName;
    private ImageView imageView;

    private TipoDetalleEquipo tipoDetalleEquipo;

    //Quitar
    private TipoJugadora tipoJugadora;

    public TipoEquipoHolder(@NonNull View itemView){
        super(itemView);
        textName = itemView.findViewById(R.id.text_view_equipo);
        imageView = itemView.findViewById(R.id.image_view_equipo);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //int id = tipoDetalleEquipo.getId();
//                String equipoName = tipoDetalleEquipo.getNombreEquipo();
//                Context context = view.getContext();
//                Intent intent = new Intent(context, DetalleEquipo.class);
//                intent.putExtra(DetalleEquipo.CAMPO_ID_DETALLE,equipoName);
//                context.startActivity(intent);
                int equipoId = tipoJugadora.getId();
                Context context = view.getContext();
                Intent intent;
                intent = new Intent(context, JugadorasActivity.class);
                intent.putExtra(JugadorasActivity.CAMPO_ID_EQUIPO, equipoId);
                context.startActivity(intent);
            }
        });
    }

    public void showData(TipoEquipo equipo) {
        this.textName.setText(equipo.getNombreEquipo());
        UtilEquipos.downloadBitmapToImageView(equipo.getPhotoEscudo(), this.imageView);
    }
}
