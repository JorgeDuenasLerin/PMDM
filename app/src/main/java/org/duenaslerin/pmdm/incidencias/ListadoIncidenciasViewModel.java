package org.duenaslerin.pmdm.incidencias;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoIncidenciasViewModel extends ViewModel {

    private MutableLiveData<List<Incidencia>> datos;

    public LiveData<List<Incidencia>> getDatos() {
        if (datos == null) {
            datos = new MutableLiveData<List<Incidencia>>();
            datos.setValue(new ArrayList<Incidencia>());
            loadData();
        }
        return datos;
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.26.110.100:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IncidenciasService service = retrofit.create(IncidenciasService.class);

        // No he ejecutado nada
        Call<List<Incidencia>> peticion = service.listIncidencias();

        peticion.enqueue(new Callback<List<Incidencia>>() {
            @Override
            public void onResponse(Call<List<Incidencia>> call, Response<List<Incidencia>> response) {
                datos.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Incidencia>> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),"Error de red", Toast.LENGTH_LONG).show();
            }
        });
    }
}
