package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActividad extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_segunda_actividad);
        crearUI();

        View.OnClickListener elQueManeja = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        asociarEventos(elQueManeja);

        setContentView(b);
    }

    private void asociarEventos(View.OnClickListener parametroManejador) {
        b.setOnClickListener(parametroManejador);
    }

    private void crearUI(){
        b = new Button(this);
    }
}