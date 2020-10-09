package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class U4LayoutsEventos extends AppCompatActivity {
    
    private static final int NROWS = 4;
    private static final int NCOLS = 4;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout lv = new LinearLayout(this);
        lv.setOrientation(LinearLayout.VERTICAL);
        tv = new TextView(this);

        View.OnClickListener elQueManeja = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tv.setText(((Button) v).getText());
            }
        };

        for(int i = 1; i <= NROWS; i++){

            LinearLayout lh = new LinearLayout(this);
            lh.setOrientation(LinearLayout.HORIZONTAL);

            // Magia para rellenar cada línea
            for(int j = 1; j <= NCOLS; j++){
                Button v = new Button(this);

                v.setText("B" + i + "" + j);
                v.setOnClickListener(elQueManeja);

                lh.addView(v);
            }

            lv.addView(lh);
        }



        tv.setText("Aquí la información");

        lv.addView(tv);

        setContentView(lv);
    }
}