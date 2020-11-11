package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class U6010_CicloVidaFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u601_ciclo_vida_fragment);
    }


    U6010_PrimerFragmento frag;


    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof U6010_PrimerFragmento) {
            frag = (U6010_PrimerFragmento) fragment;
        }
    }

    int i = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Código para pasar a la siguiente imagen

        Log.d("Evento", event.toString());

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            frag.setMensaje("Pulsado " + i++);
        }

        return super.onTouchEvent(event);
    }
}