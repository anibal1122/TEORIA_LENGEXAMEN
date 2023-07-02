package com.example.teoria_lengexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.teoria_lengexamen.configuracion.ConfigCF;
import com.example.teoria_lengexamen.configuracion.SQLiteConnection;

public class AddActivity extends AppCompatActivity {
    EditText id, nombres, apellidos, edad;
    Spinner pais;
    Spinner posicion;
    Button btningresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        id = (EditText) findViewById(R.id.txtid);
        nombres = (EditText) findViewById(R.id.txtnomb);
        apellidos = (EditText) findViewById(R.id.txtapell);
        edad = (EditText) findViewById(R.id.txted);
        pais = (Spinner) findViewById(R.id.paisesco);
        posicion = (Spinner) findViewById(R.id.posicionco);
        btningresar = (Button) findViewById(R.id.btningresar);

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            insertar_datos();
            }
        });



    }

    private void insertar_datos()
    {
        SQLiteConnection conexion = new SQLiteConnection(this, ConfigCF.namebd, null,1);
        SQLiteDatabase an = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConfigCF.nombres,nombres.getText().toString());
        values.put(ConfigCF.apellidos,apellidos.getText().toString());
        values.put(ConfigCF.edad,edad.getText().toString());
        values.put(ConfigCF.pais,pais.getSelectedItem().toString());
        values.put(ConfigCF.posicion,posicion.getSelectedItem().toString());

        Long resultado = an.insert(ConfigCF.tblfutbolistas, ConfigCF.id, values);
        if (resultado > 0)
        {
            Toast.makeText(getApplicationContext(),"Registro ingresado con exito", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Registro no se ingreso", Toast.LENGTH_LONG).show();
        }
        an.close();
        ClearScreen();
    }

    private void ClearScreen()
    {
        nombres.setText(ConfigCF.Empty);
        apellidos.setText(ConfigCF.Empty);
        edad.setText(ConfigCF.Empty);
    }
    public void activity_desplazamiento(View view)
    {
        Intent activity_desplazamiento = new Intent(this, ActivityDesplazamiento.class);
        startActivity(activity_desplazamiento);
    }

}