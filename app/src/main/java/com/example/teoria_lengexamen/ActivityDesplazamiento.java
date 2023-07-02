package com.example.teoria_lengexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityDesplazamiento extends AppCompatActivity
{
    public void NuevoFut(View view)
    {
        Intent activity_add = new Intent(this, AddActivity.class);
        startActivity(activity_add);
    }
    public void listafutbolistas(View view)
    {
        Intent activity_list_fut = new Intent(this, ListFutActivity.class);
        startActivity(activity_list_fut);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplazamiento);
    }
}