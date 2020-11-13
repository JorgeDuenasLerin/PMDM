package org.duenaslerin.pmdm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class U6023_MisDatos extends ViewModel {

    private MutableLiveData<List<Double>> datos;

    public LiveData<List<Double>> getDatos() {
        if (datos == null) {
            datos = new MutableLiveData<List<Double>>();
            datos.setValue(new ArrayList<Double>());
            loadData();
        }
        return datos;
    }

    private void loadData() {
        /*************************************************************+
         * Aquí hacemos una petición a un API externa para procesar los datos
         */
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    // Desde otro Thread podemos mandar la info de forma segura
                    List<Double> datosTrabajo = datos.getValue();
                    datosTrabajo.add(Math.random());
                    Log.d("asd", String.valueOf(Math.random()));
                    datos.postValue(datosTrabajo);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
