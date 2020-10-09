package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class U49Pruebas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        Spinner spinner = new Spinner(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Lunes1");
        adapter.add("Martes");
        adapter.add("Miércoles");
        adapter.add("Jueves");
        adapter.add("Viernes");
        adapter.add("Sábado");
        adapter.add("Domingo");
        spinner.setAdapter(adapter);
        layout.addView(spinner);
        setContentView(layout);
        //setContentView(R.layout.activity_pruebas);
    }
}