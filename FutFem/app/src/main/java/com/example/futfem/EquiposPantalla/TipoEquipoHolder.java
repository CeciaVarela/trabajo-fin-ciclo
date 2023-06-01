package com.example.futfem.EquiposPantalla;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futfem.DetalleEquipoPantalla.DetalleActivity;
import com.example.futfem.R;

public class TipoEquipoHolder extends RecyclerView.ViewHolder{
    private TextView textName;
    private ImageView imageView;
    private TipoEquipo equipo;

    public TipoEquipoHolder(@NonNull View itemView){
        super(itemView);
        textName = itemView.findViewById(R.id.text_view_equipo);
        imageView = itemView.findViewById(R.id.image_view_equipo);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int equipoId = equipo.getId();
                Context context = view.getContext();
                Intent intent = new Intent(context, DetalleActivity.class);
                intent.putExtra(DetalleActivity.CAMPO_ID_EQUIPO,equipoId);
                context.startActivity(intent);
            }
        });
    }

    public void showData(TipoEquipo equipo) {
        this.equipo = equipo;
        this.textName.setText(equipo.getNombreEquipo());
        UtilEquipos.downloadBitmapToImageView(equipo.getPhotoEscudo(), this.imageView);
    }
}
