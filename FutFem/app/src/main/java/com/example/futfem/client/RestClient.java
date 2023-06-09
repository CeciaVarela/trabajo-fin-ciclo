package com.example.futfem.client;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {

    private String BASE_REAL_URL = "http://10.0.2.2:8000";

    private String BASE_URL = BASE_REAL_URL;

    private RequestQueue queue;

    private RestClient(Context context){
        queue = Volley.newRequestQueue(context);
    }

    private static RestClient singleton = null;

    public static RestClient getInstance(Context context){
        if(singleton == null){
            singleton = new RestClient(context);
        }
        return singleton;
    }


    //Método para registrar un nuevo usuario en el servidor
    public void registerUser(String name, String surname, String email, String password,
                              Response.Listener listener, Response.ErrorListener errorListener){
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("nombre", name);
            requestBody.put("apellido",surname);
            requestBody.put("email", email);
            requestBody.put("contrasena", password);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                BASE_URL + "/v1/users",
                requestBody,
                listener,
                errorListener
        );

        this.queue.add(request);
    }


    //Método para iniciar sesión en el servidor
    public void login(JSONObject credentials, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener){
        String url = BASE_URL + "/v1/sessions";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, credentials, listener, errorListener);

        this.queue.add(request);
    }

}
