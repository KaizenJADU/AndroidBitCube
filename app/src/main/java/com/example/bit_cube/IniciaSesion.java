package com.example.bit_cube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IniciaSesion extends AppCompatActivity implements View.OnClickListener{
    Button btninise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciasesion);

        btninise = findViewById(R.id.btninic);
        btninise.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String cadenita = ((Button) view).getText().toString();
        if (cadenita.equals("Inicia Sesion")) {
            Intent intentadito = new Intent(this, Principal.class);
            startActivity(intentadito);
            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
        }
    }
}
