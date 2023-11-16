package com.example.bit_cube;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText cod, nombre, apePat, apeMat, correo, tel, contra, rfc, nomInf, apePatInf, apeMatInf, edadinf;

    Spinner sexoinf;
    Button btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        btnregis = findViewById(R.id.btnregis);
        btnregis.setOnClickListener(this);

        cod = findViewById(R.id.cod);
        nombre = findViewById(R.id.nombre);
        apePat = findViewById(R.id.apePat);
        apeMat = findViewById(R.id.apeMat);
        correo = findViewById(R.id.correo);
        tel = findViewById(R.id.tel);
        contra = findViewById(R.id.contra);
        rfc = findViewById(R.id.rfc);
        nomInf = findViewById(R.id.nomInf);
        apePatInf = findViewById(R.id.apePatInf);
        apeMatInf = findViewById(R.id.apeMatInf);
        sexoinf = findViewById(R.id.sexoinf);
        sexoinf.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sexoinf.setAdapter(adapter);
        edadinf = findViewById(R.id.edadinf);


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
            if (validarCamposLlenos()) {
                Base admin = new Base(this, "administrador", null, 1);
                SQLiteDatabase basededatos = admin.getWritableDatabase();
                String nom = nombre.getText().toString();
                String aPat = apePat.getText().toString();
                String aMat = apeMat.getText().toString();
                String cor = correo.getText().toString();
                String tEl = tel.getText().toString();
                String cont = contra.getText().toString();
                String RFC = rfc.getText().toString();
                String cOd = cod.getText().toString();
                String nominf = nomInf.getText().toString();
                String aPatinf = apePatInf.getText().toString();
                String aMatinf = apeMatInf.getText().toString();
                String edadInf = edadinf.getText().toString();
                String sexinf = sexoinf.getSelectedItem().toString();



                ContentValues registro = new ContentValues();
                registro.put("nombreUsuario",nom);
                registro.put("apePatUsuario",aPat);
                registro.put("apeMatUsuario",aMat);
                registro.put("telUsuario",tEl);
                registro.put("correoUsuario",cor);
                registro.put("contrasenaUsuario",cont);
                registro.put("RFC",RFC);
                registro.put("codigo",cOd);
                registro.put("nombreInfante",nominf);
                registro.put("apePatInfante",aPatinf);
                registro.put("apeMatInfante",aMatinf);
                registro.put("edadInfante",edadInf);
                registro.put("sexoInfante",sexinf);

                basededatos.insert("Usuario", null, registro);
                basededatos.close();
                String mensajito = "Puede llenarlo más tarde, sin embargo no contarás con reporte de progreso mensual hasta que lo lllenes";
                AlertDialog.Builder mensa = new AlertDialog.Builder(this);
                mensa.setTitle("Porfavor llena el formulario de <Especificaciones Médicas>");
                mensa.setMessage(mensajito);
                mensa.setNegativeButton("Llenar más tarde",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Registro.this, Principal.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Gracias por Registrarte, Bienvenido", Toast.LENGTH_SHORT).show();
                    }
                });
                mensa.setPositiveButton("Ir a llenar Especificaciones", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Registro.this, EspMedicas.class);
                        startActivity(intent);
                    }
                });
                AlertDialog dialog = mensa.create();
                dialog.show();

            } else {
                Toast.makeText(getApplicationContext(), "Datos no llenados", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private boolean validarCamposLlenos() {
        return !nombre.getText().toString().isEmpty() &&
                !apePat.getText().toString().isEmpty() &&
                !apeMat.getText().toString().isEmpty() &&
                !correo.getText().toString().isEmpty() &&
                !tel.getText().toString().isEmpty() &&
                !contra.getText().toString().isEmpty() &&
                !rfc.getText().toString().isEmpty() &&
                !nomInf.getText().toString().isEmpty() &&
                !apePatInf.getText().toString().isEmpty() &&
                !apeMatInf.getText().toString().isEmpty() &&
                !sexoinf.getSelectedItem().toString().isEmpty() &&
                !edadinf.getText().toString().isEmpty();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
