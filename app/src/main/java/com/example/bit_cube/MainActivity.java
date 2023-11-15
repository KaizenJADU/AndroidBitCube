package com.example.bit_cube;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnregis,btninise;
    ImageButton btnfc,btnig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnregis = findViewById(R.id.btnregis);
        btnregis.setOnClickListener(this);
        btninise = findViewById(R.id.btninise);
        btninise.setOnClickListener(this);
        btnfc = findViewById(R.id.btnfc);
        btnfc.setOnClickListener(this);
        btnig = findViewById(R.id.btnig);
        btnig.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnregis){
            Intent intentadito = new Intent (this, Registro.class);
            startActivity(intentadito);
        }
        else
        if (view.getId() == R.id.btninise) {
            Intent intentadito = new Intent(this, Iniciar_sesion.class);
            startActivity(intentadito);
            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnfc) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com")));
            
        } else if (view.getId() == R.id.btnig) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com")));

        }

    }
    }

