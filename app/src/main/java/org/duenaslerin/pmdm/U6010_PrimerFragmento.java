package org.duenaslerin.pmdm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class U6010_PrimerFragmento extends Fragment {

    private String mFilterTag = "LifecycleExample";
    private String mActivityName = "Fragment";



    public U6010_PrimerFragmento() {
        // Required empty public constructor
    }

    private TextView msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mySelf = inflater.inflate(R.layout.fragment_u601_primer_fragmento, container, false);
        msg = mySelf.findViewById(R.id.mensaje);
        return mySelf;
    }

    public void setMensaje(String sMsg){
        msg.setText(sMsg);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(mFilterTag, mActivityName + " onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(mFilterTag, mActivityName + " onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(mFilterTag, mActivityName + " onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(mFilterTag, mActivityName + " onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(mFilterTag, mActivityName + " onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(mFilterTag, mActivityName + " onDestroy");
        super.onDestroy();
    }
}