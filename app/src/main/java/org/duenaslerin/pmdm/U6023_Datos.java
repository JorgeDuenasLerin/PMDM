package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class U6023_Datos extends AppCompatActivity {

    MutableLiveData<Double> datos;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u6023__datos);
        tv = findViewById(R.id.u6022_output);

        datos = new MutableLiveData<Double>();
        // Thread principal, podemos usar setValue
        datos.setValue(0.0);

        new Thread(new Runnable() {
            public void run() {
                while(true){
                    // Desde otro Thread podemos mandar la info de forma segura
                    datos.postValue(Math.random());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        datos.observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double d) {
                tv.setText(d.toString());
            }
        });
    }
}