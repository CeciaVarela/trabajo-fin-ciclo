package com.example.futfem.client;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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


}
