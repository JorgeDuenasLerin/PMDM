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

        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");

        //wbView.loadUrl("https://play.google.com/store/apps");

        //wbView.loadUrl("http://site.educa.madrid.org/ies.villablanca.madrid/index.php/departamento-de-informatica/");
        // Usar local host
        wbView.loadUrl("http://10.0.2.2:8080/");
        //wbView.loadUrl("https://meneame.net");

        LinearLayout ll = new LinearLayout(this);
        ll.addView(wbView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));

        setContentView(ll);
    }
}