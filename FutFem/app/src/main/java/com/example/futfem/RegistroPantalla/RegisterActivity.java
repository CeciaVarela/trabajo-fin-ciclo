package com.example.futfem.RegistroPantalla;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futfem.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText getEditTextPassword2;
    private Button buttonRegister;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        editTextName = findViewById(R.id.nombre);
        editTextSurname = findViewById(R.id.apellido);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.contraseña);
        getEditTextPassword2 = findViewById(R.id.repetirContraseña);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if(editTextPassword.getText().toString().equals(getEditTextPassword2.getText().toString())){
                    Toast.makeText(context, "Usuario " + editTextName.getText().toString(), Toast.LENGTH_LONG).show();
                    //registerNewUser();
                }else{
                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
