package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class U5000_LayoutsXML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u5__layouts_x_m_l);
    }

    public void pulsado(View v){
        Toast toast = Toast.makeText(getApplicationContext(), "Botón pulsado",
                Toast.LENGTH_SHORT);
        toast.show();
    }
}