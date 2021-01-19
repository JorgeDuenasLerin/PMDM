package arquitectura.paginación;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import arquitectura.PollsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionPaginatedListViewModel extends ViewModel {
    private MutableLiveData<QuestionPaginated> questions;
    public LiveData<QuestionPaginated> getQuestions() {
        if (questions == null) {
            questions = new MutableLiveData<QuestionPaginated>();
            loadQuestions();
        }
        return questions;
    }

    private void loadQuestions() {
        // Accede al API para descargar datos
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.12:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        PollsService service = retrofit.create(PollsService.class);
        /*
        Call<QuestionPaginated> repos = service.listRepos();

        QuestionPaginated listOfQuestions;

        repos.enqueue(new Callback<QuestionPaginated>() {
            @Override
            public void onResponse(Call<QuestionPaginated> call, Response<QuestionPaginated> response) {
                questions.setValue(response.body());
            }

            @Override
            public void onFailure(Call<QuestionPaginated> call, Throwable t) {
                Log.d("Error acceso datos", t.getMessage());
            }
        });

         */
    }
}