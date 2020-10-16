package org.duenaslerin.pmdm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class U411_ActividadConDialog extends AppCompatActivity {

    private int n = 0;
    private Button boton;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button b = new Button(this);
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                abrirDialogo();
            }
        });
        b.setText("Púlsame!");

        setContentView(b);
    }

    private void abrirDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mi super TOAST");
        CharSequence texto = "¿Quieres incrementar n?";

        builder.setMessage(texto);
        builder.setPositiveButton("Sí", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        n++;
                        mostrar(""+n);
                        dialog.dismiss();
                    }
                }
        );

        builder.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mostrar("Operación cancelada");
                        dialog.cancel();
                    }
                });
        dialog = builder.create();
        dialog.show();
    }

    private void mostrar(String mensaje) {
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }


}