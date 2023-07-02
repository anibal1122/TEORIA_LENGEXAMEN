package com.example.teoria_lengexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.teoria_lengexamen.configuracion.Cfutbolistas;
import com.example.teoria_lengexamen.configuracion.ConfigCF;
import com.example.teoria_lengexamen.configuracion.SQLiteConnection;

import java.util.ArrayList;

public class ListFutActivity extends AppCompatActivity
{

    SQLiteConnection conexion;
    ListView list;
    ArrayList<Cfutbolistas> listfutbolistas;
    ArrayList<String> arreglofutbolistas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fut);

        conexion = new SQLiteConnection(this, ConfigCF.namebd, null, 1);
        list = (ListView) findViewById(R.id.lista);

        ObtenerTabla();

        ArrayAdapter apd = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglofutbolistas);
        list.setAdapter(apd);

    }

    private void ObtenerTabla()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cfutbolistas cfutbolistas = null;
        listfutbolistas = new ArrayList<Cfutbolistas>();

        // Cursor de Base de Datos
        Cursor cursor = db.rawQuery(ConfigCF.SelectTBFutbolistas,null);

        // recorremos el cursor
        while(cursor.moveToNext())
        {
            Cfutbolistas futbolistas = new Cfutbolistas();
            futbolistas.setId(cursor.getInt(0));
            futbolistas.setNombres(cursor.getString(1));
            futbolistas.setApellidos(cursor.getString(2));
            futbolistas.setPais(cursor.getString(3));
            futbolistas.setPosicion(cursor.getString(4));
            futbolistas.setEdad(cursor.getInt(5));
            listfutbolistas.add(futbolistas);
        }

        cursor.close();

        fillData();
    }

    private void fillData()
    {
        arreglofutbolistas = new ArrayList<String>();

        for(int i=0; i < listfutbolistas.size(); i++)
        {
            arreglofutbolistas.add(listfutbolistas.get(i).getId() + " - "
                    +listfutbolistas.get(i).getNombres() + " - "
                    +listfutbolistas.get(i).getApellidos());
        }

    }
    public void activity_desplazamiento(View view)
    {
        Intent activity_desplazamiento = new Intent(this, ActivityDesplazamiento.class);
        startActivity(activity_desplazamiento);
    }

}