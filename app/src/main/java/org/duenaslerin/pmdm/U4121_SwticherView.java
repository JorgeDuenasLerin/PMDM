package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewSwitcher;

public class U4121_SwticherView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_u4121__t_e_m_p_o_r_a_l);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        final ViewSwitcher viewSwitcher = new ViewSwitcher(this);
        layout.addView(viewSwitcher, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 2.0f));

        Animation in = AnimationUtils.loadAnimation(this,R.anim.clockwise);
        viewSwitcher.setInAnimation(in);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.clockwise);
        //Animation out = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        viewSwitcher.setOutAnimation(out);

        Button boton = new Button(this);
        layout.addView(boton, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.0f));
        boton.setText("Cambiar");

        boton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(viewSwitcher.getDisplayedChild() > 0)
                            viewSwitcher.showPrevious();
                        else
                            viewSwitcher.showNext();
                    }
                }
        );

        Button boton1 = new Button(this);
        Button boton2 = new Button(this);

        boton1.setText("1");
        boton2.setText("2");

        viewSwitcher.addView(boton1, -1, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        viewSwitcher.addView(boton2, -1, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        setContentView(layout);
    }
}