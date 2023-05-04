package com.example.futfem.RegistroPantalla;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.futfem.R;
import com.example.futfem.client.RestClient;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private TextView textViewRegistro;
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPassword2;
    Button buttonRegister;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        textViewRegistro = findViewById(R.id.registro);
        editTextName = findViewById(R.id.nombre);
        editTextSurname = findViewById(R.id.apellido);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.contraseña);
        editTextPassword2 = findViewById(R.id.repetirContraseña);
        buttonRegister = findViewById(R.id.registrarse);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                //Comprobar que las dos contraseñas coincidan
                if (editTextPassword.getText().toString().equals(editTextPassword2.getText().toString())) {
                    Toast.makeText(context, "Usuario " + editTextName.getText().toString(), Toast.LENGTH_LONG).show();
                    registerNewUser();
                } else {
                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void registerNewUser() {
        RestClient.getInstance(this).registerUser(
                editTextName.getText().toString(),
                editTextSurname.getText().toString(),
                editTextEmail.getText().toString(),
                editTextPassword.getText().toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.length() > 0) {
                            Toast.makeText(context, "El email ya está registrado", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(context, "El usuario fue creado con éxito" , Toast.LENGTH_LONG).show();
                            finish();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error.networkResponse == null) {
                            Toast.makeText(context,"Es imposible contectarse al servidor "+error.getMessage(), Toast.LENGTH_LONG).show();
                        } else {
                            int serverCode = error.networkResponse.statusCode;
                            Toast.makeText(context, "El servidor respondió con un" + serverCode , Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }


}
