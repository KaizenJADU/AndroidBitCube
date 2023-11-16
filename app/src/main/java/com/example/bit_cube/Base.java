package com.example.bit_cube;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Base extends SQLiteOpenHelper {

    public Base(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase basesita) {
        basesita.execSQL("create table Usuario(idUsuario int primary key, nombreUsuario text," +
                " apePatUsuario text,apeMatUsuario text, telUsuario int, correoUsuario text, contrasenaUsuario text," +
                "RFC text, codigo int, nombreInfante text, apePatInfante text, apeMatInfante text, " +
                "edadInfante int, sexoInfante text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
