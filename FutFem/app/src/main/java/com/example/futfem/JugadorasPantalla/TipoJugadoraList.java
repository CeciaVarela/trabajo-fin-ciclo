package com.example.futfem.JugadorasPantalla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TipoJugadoraList {
    private List<TipoJugadora> jugadoras;

    public TipoJugadoraList(JSONArray array) {
        jugadoras = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject jsonElement = array.getJSONObject(i);
                TipoJugadora aJugadora = new TipoJugadora(jsonElement);
                jugadoras.add(aJugadora);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<TipoJugadora> getJugadoras() {
        return jugadoras;
    }
}
