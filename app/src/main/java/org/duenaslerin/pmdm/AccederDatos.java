package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AccederDatos extends AppCompatActivity {

    TextView tv;
    AccederDatosViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceder_datos);

        tv = findViewById(R.id.textViewOutput);

        vm = new ViewModelProvider(this).get(AccederDatosViewModel.class);

        vm.obtenerDatos().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // Actualizar el UI
                tv.setText(s);
            }
        });
    }
}