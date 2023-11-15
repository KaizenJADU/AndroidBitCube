package com.example.bit_cube;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText cod;
    Button btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        btnregis = findViewById(R.id.btnregis);
        btnregis.setOnClickListener(this);

        cod = findViewById(R.id.cod);
        cod.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if (text.length() > 4) {
                    String newText = text.substring(0, 4);
                    cod.setText(newText);
                    cod.setSelection(newText.length());
                    Toast.makeText(getApplicationContext(), "Máximo 4 números", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        String cadenita = ((Button) view).getText().toString();
        if (cadenita.equals("Regístrate")) {
            Intent intentadito = new Intent(this, Principal.class);
            startActivity(intentadito);
            Toast.makeText(getApplicationContext(), "Gracias por Registrarte, Bienvenido", Toast.LENGTH_SHORT).show();
        }
    }
}
