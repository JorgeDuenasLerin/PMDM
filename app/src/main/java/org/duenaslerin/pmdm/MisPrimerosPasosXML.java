package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MisPrimerosPasosXML extends AppCompatActivity {

    TextView l;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_primeros_pasos_x_m_l);

        b = findViewById(R.id.miboton);
        l = findViewById(R.id.milabel);

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                l.setText("Boton pulsado");
            }
        });

    }
}