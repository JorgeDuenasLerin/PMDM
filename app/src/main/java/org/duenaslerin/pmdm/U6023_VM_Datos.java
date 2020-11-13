package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class U6023_VM_Datos extends AppCompatActivity {

    U6023_MisDatos misDatos;
    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u6023__vm_datos);

        misDatos = new ViewModelProvider(this).get(U6023_MisDatos.class);

        tv = findViewById(R.id.u6023_output_vm);

        misDatos.getDatos().observe(this, new Observer<List<Double>>() {
            @Override
            public void onChanged(List<Double> doubles) {
                tv.setText("");
                for(Double d: doubles){
                    tv.setText(tv.getText()+d.toString()+"\n");
                }
            }
        });
    }
}