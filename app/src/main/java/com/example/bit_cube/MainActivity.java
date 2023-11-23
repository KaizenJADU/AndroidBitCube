package com.example.bit_cube;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnregis,btnin;
    ImageButton btnfc, btnig;
    TextView etcorrreo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnregis = findViewById(R.id.btnregis);
        btnregis.setOnClickListener(this);
        btnin = findViewById(R.id.inicia);
        btnin.setOnClickListener(this);
        btnfc = findViewById(R.id.btnfc);
        btnfc.setOnClickListener(this);
        btnig = findViewById(R.id.btnig);
        btnig.setOnClickListener(this);
        etcorrreo = findViewById(R.id.etcorreo);
        etcorrreo.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);
        etcorrreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etcorrreo.getText().toString();
                composeEmail(new String[]{email}, "Asunto del correo");
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnregis) {
            Intent intentadito = new Intent(this, Registro.class);
            startActivity(intentadito);
        } else if (view.getId() == R.id.btnfc) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com")));

        } else if (view.getId() == R.id.btnig) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com")));

        } else if (view.getId() == R.id.inicia) {
            Intent intentadito = new Intent(this, IniciaSesion.class);
            startActivity(intentadito);

        }

    }

    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("Emmail:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "No hay aplicación de correo electrónico disponible", Toast.LENGTH_SHORT).show();
        }
    }
}
