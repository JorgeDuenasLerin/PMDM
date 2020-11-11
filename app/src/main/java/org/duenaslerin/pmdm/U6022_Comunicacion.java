package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

public class U6022_Comunicacion extends AppCompatActivity
    implements U6022_Fragmento.CuandoPulseBotonListener{


    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u6022__comunicacion);
        tv = findViewById(R.id.textViewRoger);

        /*
        // Forma con el fragmentManager
        U6022_Fragmento headlinesFragment = (U6022_Fragmento) getSupportFragmentManager().findFragmentById(R.id.fragment_comm_id);
        headlinesFragment.estableceManejadorEvento(this);
        */
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        // Forma con el evento Attach de los fragmentos
        if (fragment instanceof U6022_Fragmento) {
            U6022_Fragmento headlinesFragment = (U6022_Fragmento) fragment;
            headlinesFragment.estableceManejadorEvento(this);
        }

    }

    @Override
    public void hanPulsadoElBoton(String mensaje) {
        // Hacer acción
        // estableceremos un mensaje en textView
        tv.setText(mensaje);
    }
}