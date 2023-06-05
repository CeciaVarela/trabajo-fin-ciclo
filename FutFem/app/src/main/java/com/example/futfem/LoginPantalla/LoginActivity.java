package com.example.futfem.LoginPantalla;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.futfem.HomeActivityDrawer.HomeFragment;
import com.example.futfem.R;
import com.example.futfem.RegistroPantalla.RegisterActivity;
import com.example.futfem.client.RestClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        AppCompatButton buttonLogin = findViewById(R.id.iniciarSesion);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usuario = findViewById(R.id.email);
                EditText contrasena = findViewById(R.id.contrasena);
                String email = usuario.getText().toString();
                String pass = contrasena.getText().toString();

                JSONObject credentials = new JSONObject();
                try {
                    credentials.put("email", email);
                    credentials.put("contrasena", contrasena);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String token = response.getString("tokenSession");
                            SharedPreferences.Editor editor = context.getSharedPreferences("FUTFEM_APP", Context.MODE_PRIVATE).edit();
                            editor.putString("tokenSession", token);
                            editor.apply();
                            //Llamada a datos.
                            Intent intent = new Intent(context, HomeFragment.class);
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                };
                RestClient.getInstance(context).login(credentials, listener, errorListener);
            }
        });
    }

}




