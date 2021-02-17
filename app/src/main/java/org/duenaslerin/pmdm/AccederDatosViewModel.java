package org.duenaslerin.pmdm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AccederDatosViewModel extends ViewModel {

    private MutableLiveData<String> datos;

    public LiveData<String> obtenerDatos() {
        if (datos == null) {
            datos = new MutableLiveData<String>();
            datos.setValue("");
            loadData();
        }
        return datos;
    }

    private void loadData() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                StringBuffer content = new StringBuffer();

                try {
                    URL url = new URL("http://172.26.110.100:8000/polls/api/question/");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    //StringBuffer content = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();

                    datos.postValue(content.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}
