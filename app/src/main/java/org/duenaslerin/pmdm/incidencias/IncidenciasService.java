package org.duenaslerin.pmdm.incidencias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IncidenciasService {

    @GET("incidencias/api/incidencia/")
    Call<List<Incidencia>> listIncidencias();
}
