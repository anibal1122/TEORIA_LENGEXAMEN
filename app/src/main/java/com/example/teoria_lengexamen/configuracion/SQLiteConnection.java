package com.example.teoria_lengexamen.configuracion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConnection extends SQLiteOpenHelper
{

    public SQLiteConnection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        /* Creacion de objectos de base de datos */
        sqLiteDatabase.execSQL(ConfigCF.CreateTBFutbolistas);  // Creando la tabla de Futbolistas en sqlite..
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(ConfigCF.DropTBFutbolistas);
        onCreate(sqLiteDatabase);
    }
}
