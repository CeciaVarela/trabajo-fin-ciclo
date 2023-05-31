package com.example.futfem.JugadorasPantalla;

import org.json.JSONException;
import org.json.JSONObject;

public class TipoJugadora {
    private int id;
    private String nombreJugadora;
    private String photoJugadora;
    private String posicionJugadora;

    public TipoJugadora(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.nombreJugadora = json.getString("nombreJugadora");
        this.photoJugadora = json.getString("photoJugadora");
        this.posicionJugadora = json.getString("posicionJugadora");
    }

    public int getId() {
        return id;
    }

    public String getNombreJugadora() {
        return nombreJugadora;
    }

    public String getPhotoJugadora() {
        return photoJugadora;
    }

    public String getPosicionJugadora() {
        return posicionJugadora;
    }
}
