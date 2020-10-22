package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class U4122_Sprite_FlipperView extends AppCompatActivity {

    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int[] resourceIds = {
                R.drawable.megaman_animacion1,
                R.drawable.megaman_animacion2,
                R.drawable.megaman_animacion3,
                R.drawable.megaman_animacion4,
                R.drawable.megaman_animacion5,
                R.drawable.megaman_animacion6,
                R.drawable.megaman_animacion7,
                R.drawable.megaman_animacion8
        };

        vf = new ViewFlipper(this);

        for(int resourceId: resourceIds){
            ImageView i = new ImageView(this);
            i.setImageResource(resourceId);
            vf.addView(i);
        }

        setContentView(vf);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Código para pasar a la siguiente imagen

        Log.d("Evento", event.toString());

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            vf.showNext();
        }

        return super.onTouchEvent(event);
    }

}