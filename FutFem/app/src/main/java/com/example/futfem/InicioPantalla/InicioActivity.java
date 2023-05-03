package com.example.futfem.InicioPantalla;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futfem.R;

public class InicioActivity extends AppCompatActivity {

    private Context context = this;
    private ImageView imageViewLogo;
    private Button buttonIniciarSesion;
    private Button buttonRegistro;

    private TextView continuarSinRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_activity);
        imageViewLogo = findViewById(R.id.logotipo);
        buttonIniciarSesion = findViewById(R.id.boton_sesion);
        buttonRegistro = findViewById(R.id.boton_registro);
        continuarSinRegistrarse = findViewById(R.id.continuar);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myIntent = new Intent(context, LoginActivity.class);
                //context.startActivity(myIntent);
            }
        });

        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myIntent = new Intent(context, RegisterActivity.class);
                //context.startActivity(myIntent);
            }
        });

        continuarSinRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myIntent = new Intent(context, MainActivityDrawer.class);
                //context.startActivity(myIntent);
            }
        });
    }
}
