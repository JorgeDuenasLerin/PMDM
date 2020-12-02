package org.duenaslerin.pmdm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class U10001_Intent extends AppCompatActivity {

    private static final int REQUEST_CODE = 0x00001; // Número aleatorio único en la app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u10001_01__intent);
    }

    public void clickWeb(View v){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://developer.android.com"));
        startActivity(i);
    }

    public void clickSMS(View v){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("sms:5555555"));
        i.putExtra("sms_body", "Ejemplo de cuerpo de mensaje");
        startActivity(i);
    }

    public void clickDial(View v){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:666666666"));
        startActivity(i);
    }

    public void intentLanzar(View v){
        Intent i = new Intent(this, U10002_OtraActividad.class);
        i.putExtra("SMS","Hola actividad 2, saludo desde 1");
        startActivity(i);
    }

    private void intentLlamar(){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:666666666"));
        startActivity(i);
    }

    public void clickCall(View v){
        /*

        */

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            intentLlamar();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] { Manifest.permission.CALL_PHONE }, REQUEST_CODE); // Marca única que me invento
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: // Marca única que recibo
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                    intentLlamar();

                }  else {
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.

                    Toast.makeText(this, "Si no das permisos no hay llamada. No call, no fun :(", Toast.LENGTH_LONG).show();

                }
                return;
        }
        // Other 'case' lines to check for other
        // permissions this app might request.
    }
}