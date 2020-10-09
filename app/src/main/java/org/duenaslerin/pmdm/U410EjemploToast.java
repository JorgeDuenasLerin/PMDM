package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class U410EjemploToast extends AppCompatActivity {

    private int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button b = new Button(this);
        b.setText("Pulsa!");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence cs = "Pulsado " + n++;
                Toast t = Toast.makeText(getApplicationContext(), cs, Toast.LENGTH_SHORT);
                t.show();
            }
        });

        setContentView(b);
    }
}