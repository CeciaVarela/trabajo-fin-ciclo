package com.example.futfem.EquiposPantalla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TipoEquipoList {
    private List<TipoEquipo> equipos;

    public TipoEquipoList(JSONArray array){
        equipos = new ArrayList<>();
        for(int i = 0; i < array.length(); i++){
            try{
                JSONObject jsonElement = array.getJSONObject(i);
                TipoEquipo aEquipo = new TipoEquipo(jsonElement);
                equipos.add(aEquipo);
            }catch (JSONException e){
                throw new RuntimeException(e);
            }
        }
    }

    public List<TipoEquipo> getEquipos(){
        return equipos;
    }
}
