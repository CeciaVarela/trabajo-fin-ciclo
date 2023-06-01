package com.example.futfem.JugadorasPantalla;

import org.json.JSONException;
import org.json.JSONObject;

public class TipoJugadora {

    private int id;
    private String nombreJugadora;
    private String photoJugadora;
    private String numeroJugadora;
    private String posicionJugadora;
//    private int idEquipo;

    public TipoJugadora (JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.nombreJugadora = json.getString("nombreJugadora");
        this.photoJugadora = json.getString("photoJugadora");
        this.numeroJugadora = json.getString("numeroJugadora");
        this.posicionJugadora = json.getString("posicionJugadora");
//        this.idEquipo = json.getInt("idEquipo");
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

    public String getNumeroJugadora() {
        return numeroJugadora;
    }

    public String getPosicionJugadora() {
        return posicionJugadora;
    }

//    public int getIdEquipo() {
//        return idEquipo;
//    }
}
