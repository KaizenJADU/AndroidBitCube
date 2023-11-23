package com.example.bit_cube;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EspMedicas extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner comboal;
    Button btnesp;
    EditText fechadiag,masenfer,enlugarde,revision,listmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espmedicas);

        btnesp = findViewById(R.id.btnesp);
        btnesp.setOnClickListener(this);

        fechadiag = findViewById(R.id.fechadiag);
        masenfer = findViewById(R.id.masenfer);
        enlugarde = findViewById(R.id.enlugarde);
        revision = findViewById(R.id.revision);
        listmed = findViewById(R.id.listmed);

        comboal = findViewById(R.id.spinal);
        comboal.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinalergia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        comboal.setAdapter(adapter);

    }
    @Override
    public void onClick (View view){
        String cadenita = ((Button)view).getText().toString();
        if(cadenita.equals("RegistrarDatos")){
            Base admin = new Base(this, "administrador", null, 1);
            SQLiteDatabase basededatos = admin.getWritableDatabase();
            String nom = listmed.getText().toString();
            String aPat = fechadiag.getText().toString();
            String aMat = masenfer.getText().toString();
            String cor = enlugarde.getText().toString();
            String tEl = revision.getText().toString();
            String sexinf = comboal.getSelectedItem().toString();




            ContentValues registro = new ContentValues();
            registro.put("medicamentos",nom);
            registro.put("fechadiag",aPat);
            registro.put("masenfer",aMat);
            registro.put("revision",tEl);
            registro.put("tratMed",cor);
            registro.put("alergias",sexinf);
            basededatos.insert("EspecificacionMed", null, registro);
            basededatos.close();
            Intent intent = new Intent(this, Principal.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Gracias por Registrarte, Bienvenido", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
