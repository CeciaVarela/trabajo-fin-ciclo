package com.example.futfem.LoginPantalla;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.futfem.R;
import com.example.futfem.RegistroPantalla.RegisterActivity;
import com.example.futfem.client.RestClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private Context context = this;

    private RequestQueue requestQueue;
    private TextView textViewInicio;
    private ImageView imageViewLogotipo;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView crearCuenta;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        textViewInicio = findViewById(R.id.inicioSesion);
        imageViewLogotipo = findViewById(R.id.imageView);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.contraseña);
        crearCuenta = findViewById(R.id.registro);
        buttonLogin = findViewById(R.id.iniciarSesion);

        requestQueue = Volley.newRequestQueue(this);


        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, RegisterActivity.class);
                context.startActivity(myIntent);
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUserSession();
            }
        });
    }

    public void startUserSession() {
        RestClient.getInstance(this).loginUser(
                editTextEmail.getText().toString(),
                editTextPassword.getText().toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String receivedToken="";
                        String email = editTextEmail.getText().toString();
                        String password = editTextPassword.getText().toString();
                        int id;
                        try {
                            if (email.equals(response.getJSONObject(String.valueOf(0)).getString("email")) && password.equals(response.getJSONObject(String.valueOf(0)).getString("password"))){
                                receivedToken = response.getString("sessionToken");
                                id = response.getJSONObject(String.valueOf(0)).getInt("id");
                                SharedPreferences preferences = getSharedPreferences("SESSIONS_APP_PREFS", MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("VALID_EMAIL", editTextEmail.getText().toString());
                                editor.putString("VALID_TOKEN", receivedToken);
                                editor.putInt("ID", id);
                                editor.commit();
                                finish();
                                //Intent myIntent = new Intent(context, MainActivity.class);
                                //context.startActivity(myIntent);
                            }else{
                                Toast.makeText(context, "Contraseña incorrecta: ", Toast.LENGTH_LONG).show();
                            }
                        }catch(JSONException e){
                            throw new RuntimeException(e);
                        }
                        Toast.makeText(context, "Token: " + receivedToken, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error.networkResponse == null){

                        }else{
                            int serverCode = error.networkResponse.statusCode;
                            Toast.makeText(context,"El servidor respondió con: " + serverCode,Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}




