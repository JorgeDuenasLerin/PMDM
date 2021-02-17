package org.duenaslerin.pmdm.incidencias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.duenaslerin.pmdm.R;
import org.duenaslerin.pmdm.U12000_Adaptador;
import org.duenaslerin.pmdm.U6023_MisDatos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoIncidencias extends AppCompatActivity {

    IncidenciaAdapter adapter;
    ListadoIncidenciasViewModel misDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_incidencias);

        RecyclerView recyclerView = findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IncidenciaAdapter(this);
        recyclerView.setAdapter(adapter);

        misDatos = new ViewModelProvider(this).get(ListadoIncidenciasViewModel.class);

        misDatos.getDatos().observe(this, new Observer<List<Incidencia>>() {
            @Override
            public void onChanged(List<Incidencia> incidencias) {
                adapter.addData(new ArrayList(incidencias));
            }
        });
    }
}