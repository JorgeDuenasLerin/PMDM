package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import resultadosapi.ResultService;
import resultadosapi.pojo.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class U12000_ListaDeElementos extends AppCompatActivity {

    U12000_Adaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u12000__lista_de_elementos);

        // data to populate the RecyclerView with


        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                ResultService servicio = retrofit.create(ResultService.class);

                Call<List<Result>> llamada =  servicio.listResult();

                llamada.enqueue(new Callback<List<Result>>() {
                    @Override
                    public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                        for(Result r : response.body()){
                            Log.d("Resultado", r.score);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Result>> call, Throwable t) {
                        Log.d("Resultado","Fallo en la petición");
                    }
                });
            }
        }).start();
















        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new U12000_Adaptador(this);
        adapter.setClickListener(new U12000_Adaptador.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        Button b = findViewById(R.id.bCarga);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> info = new ArrayList<>();
                info.add("Horse");
                info.add("Cow");
                info.add("Camel");
                info.add("Sheep");
                info.add("Goat");
                adapter.addData(info);
            }
        });

    }
}