package com.example.futfem.SplashScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futfem.InicioPantalla.InicioActivity;
import com.example.futfem.R;

public class SplashScreen extends AppCompatActivity {

    Handler handler;
    ImageView img;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        img = findViewById(R.id.image);
        img.animate().alphaBy(1).setDuration(4000);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(context, InicioActivity.class);
                startActivity(dsp);
                finish();
            }
        },4000);
    }
}
