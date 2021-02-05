package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class U10002_OtraActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u10002__otra_actividad);

        TextView tv = findViewById(R.id.tvMSG);
        Intent intentoQueMeHaLanzadoComoActividad = getIntent();
        String mensaje = intentoQueMeHaLanzadoComoActividad.getStringExtra("SMS");
        tv.setText(mensaje);
    }

    public void clickCerrar(View v){
        finish();
    }
}