package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import org.duenaslerin.pmdm.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AccederDatos extends AppCompatActivity {

    TextView tv;

    final StringBuffer content = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceder_datos);

        tv = findViewById(R.id.textViewOutput);


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
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

                    Log.d("Prueba", content.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();


    }
}