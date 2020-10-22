package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class U413_WebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final WebView wbView = new WebView(this);

        WebSettings settings = wbView.getSettings();

        //settings.setJavaScriptEnabled(true);
        //wbView.loadUrl("https://play.google.com/store/apps");

        wbView.loadUrl("https://site.educa.madrid.org/ies.villablanca.madrid/index.php/departamento-de-informatica/");
        // Usar local host
        //wbView.loadUrl("http://10.0.2.2:8000/index.html");

        setContentView(wbView);
    }
}