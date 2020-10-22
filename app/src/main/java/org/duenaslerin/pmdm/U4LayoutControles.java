package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class U4LayoutControles extends AppCompatActivity {

    private static final int NROWS = 4;
    private static final int NCOLS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout lv = new LinearLayout(this);
        lv.setOrientation(LinearLayout.VERTICAL);

        for(int i = 1; i <= NROWS; i++){

            LinearLayout lh = new LinearLayout(this);
            lh.setOrientation(LinearLayout.HORIZONTAL);

            // Magia para rellenar cada línea
            for(int j = 1; j <= NCOLS; j++){
                TextView v;

                if(Math.random()<0.5){
                    v = new TextView(this);
                    v.setText("Label" + i + j);
                } else {
                    v = new EditText(this);
                    v.setText("Edit" + i + j);
                }

                lh.addView(v);
            }

            lv.addView(lh);
        }

        ImageView iv = new ImageView(this);

        lv.addView(iv);


        LinearLayout recuperadoFila = (LinearLayout) lv.getChildAt(2);
        View recuperadoElemento = (View) recuperadoFila.getChildAt(2);
        recuperadoElemento.setBackgroundColor(Color.BLACK);

        setContentView(lv);
    }
}