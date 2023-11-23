package com.example.bit_cube;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IniciaSesion extends AppCompatActivity implements View.OnClickListener{
    Button btninise, btnVolver;
    EditText editCorreo, editContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciasesion);

        btninise = findViewById(R.id.btninic);

        editCorreo = findViewById(R.id.editcorreoo);
        editContrasena = findViewById(R.id.contra);
        btnVolver = findViewById(R.id.volver);
        btninise.setOnClickListener(this);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IniciaSesion.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        String correo = editCorreo.getText().toString();
        String contrasena = editContrasena.getText().toString();

        if (validarUsuario(correo, contrasena)) {
            Intent intentadito = new Intent(this, Principal.class);
            startActivity(intentadito);
            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarUsuario(String correo, String contrasena) {
        Base admin = new Base(this, "administrador", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        String[] parametros = {correo, contrasena};
        String[] campos = {"nombreUsuario"};

        Cursor cursor = db.query("Usuario", campos, "correoUsuario =? AND contrasenaUsuario =?", parametros, null, null, null);

        if (cursor.moveToFirst()) {
            cursor.close();
            db.close();
            return true;
        } else {
            cursor.close();
            db.close();
            return false;
        }
    }
}