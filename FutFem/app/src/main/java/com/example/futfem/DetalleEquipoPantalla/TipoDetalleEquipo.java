package com.example.futfem.DetalleEquipoPantalla;

import org.json.JSONException;
import org.json.JSONObject;

public class TipoDetalleEquipo {
    private int id;
    private String nombreEquipo;
    private String photoEscudo;
    private String photoEstadio;
    private String estadio;
    private String anoFundacion;
    private String entrenador;

    public TipoDetalleEquipo(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.nombreEquipo = json.getString("nombreEquipo");
        this.photoEscudo = json.getString("photoEscudo");
        this.photoEstadio = json.getString("photoEstadio");
        this.estadio = json.getString("estadio");
        this.anoFundacion = json.getString("anoFundacion");
        this.entrenador = json.getString("entrenador");
    }

    public int getId() {
        return id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getPhotoEscudo() {
        return photoEscudo;
    }

    public String getPhotoEstadio() {
        return photoEstadio;
    }

    public String getEstadio() {
        return estadio;
    }

    public String getAnoFundacion() {
        return anoFundacion;
    }

    public String getEntrenador() {
        return entrenador;
    }
}
