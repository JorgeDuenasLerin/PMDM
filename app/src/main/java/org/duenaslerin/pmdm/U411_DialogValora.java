package org.duenaslerin.pmdm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class U411_DialogValora extends AppCompatActivity {

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Math.random()<0.25){
            mostrarDialogPregunta();
        }

        setContentView(R.layout.activity_u411__dialog_valora);
    }

    private void mostrarDialogPregunta(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Valórame!");
        builder.setMessage("Valora la aplicación en Google Play");

        builder.setPositiveButton("Sí", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mostrarDialogVota();
                    }
                }
        );

        builder.setNeutralButton("Más tarde", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mostrar("La valora más tarde");
                    }
                }
        );

        builder.setNegativeButton("Nunca!", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mostrar("Guardar no volver a mostrar");
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void mostrarDialogVota(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Valórame!");

        CharSequence[] valoraciones = {"1 estrella", "2 estrellas", "3 estrellas", "4 estrellas", "5 estrellas"};
        builder.setItems(valoraciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mostrar(String.format("Hemos conseguido %s estrellas", (i+1)));
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void mostrar(String mensaje) {
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }
}