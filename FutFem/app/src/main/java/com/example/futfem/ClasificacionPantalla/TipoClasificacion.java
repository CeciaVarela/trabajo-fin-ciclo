package com.example.futfem.ClasificacionPantalla;

import org.json.JSONException;
import org.json.JSONObject;

public class TipoClasificacion {
    private int id;
    private String nombreEquipo;
    private String points;
    private String partidosJugador;
    private String partidosGanados;
    private String partidosEmpatados;
    private String partidosPerdidos;
    private String golesFavor;
    private String golesContra;

    public TipoClasificacion(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.nombreEquipo = json.getString("nombreEquipo");
        this.points = json.getString("points");
        this.partidosJugador = json.getString("partidosJugador");
        this.partidosGanados = json.getString("partidosGanados");
        this.partidosEmpatados = json.getString("partidosEmpatados");
        this.partidosPerdidos = json.getString("partidosPerdidos");
        this.golesFavor = json.getString("golesFavor");
        this.golesContra = json.getString("golesContra");
    }

    public int getId() {
        return id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getPoints() {
        return points;
    }

    public String getPartidosJugador() {
        return partidosJugador;
    }

    public String getPartidosGanados() {
        return partidosGanados;
    }

    public String getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public String getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public String getGolesFavor() {
        return golesFavor;
    }

    public String getGolesContra() {
        return golesContra;
    }
}
