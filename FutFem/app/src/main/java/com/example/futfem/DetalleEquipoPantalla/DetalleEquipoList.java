package com.example.futfem.DetalleEquipoPantalla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetalleEquipoList {
    private List<DetalleEquipo> detalleEquipos;

    public DetalleEquipoList(JSONArray array) {
        detalleEquipos = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject jsonElement = array.getJSONObject(i);
                DetalleEquipo aDetalleEquipo = new DetalleEquipo(jsonElement);
                detalleEquipos.add(aDetalleEquipo);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<DetalleEquipo> getDetalleEquipos() {
        return detalleEquipos;
    }
}
