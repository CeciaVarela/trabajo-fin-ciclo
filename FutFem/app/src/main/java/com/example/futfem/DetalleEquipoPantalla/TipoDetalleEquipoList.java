package com.example.futfem.DetalleEquipoPantalla;

import com.example.futfem.EquiposPantalla.TipoEquipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TipoDetalleEquipoList {
    private List<TipoDetalleEquipo> detalleEquipos;

    public TipoDetalleEquipoList(JSONArray array) {
        detalleEquipos = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject jsonElement = array.getJSONObject(i);
                TipoDetalleEquipo aDetalleEquipo = new TipoDetalleEquipo(jsonElement);
                detalleEquipos.add(aDetalleEquipo);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<TipoDetalleEquipo> getDetalleEquipos() {
        return detalleEquipos;
    }
}
