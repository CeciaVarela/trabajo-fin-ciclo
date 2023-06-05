package com.example.futfem.ClasificacionPantalla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TipoClasificacionList {
    private List<TipoClasificacion> clasificaciones;

    public TipoClasificacionList(JSONArray array) {
        clasificaciones = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject jsonElement = array.getJSONObject(i);
                TipoClasificacion aClasificacion = new TipoClasificacion(jsonElement);
                clasificaciones.add(aClasificacion);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<TipoClasificacion> getClasificaciones(){
        return clasificaciones;
    }
}
