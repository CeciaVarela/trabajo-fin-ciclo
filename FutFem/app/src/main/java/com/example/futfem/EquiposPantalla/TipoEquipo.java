package com.example.futfem.EquiposPantalla;

import org.json.JSONException;
import org.json.JSONObject;

public class TipoEquipo {
    private int id;
    private String nombreEquipo;
    private String fotoEscudo;

    public TipoEquipo(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.nombreEquipo = json.getString("nombreEquipo");
        this.fotoEscudo = json.getString("fotoEscudo");
    }

    public int getId() {
        return id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getFotoEscudo() {
        return fotoEscudo;
    }
}
