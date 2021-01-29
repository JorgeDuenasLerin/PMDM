package arquitectura;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionListViewModel extends ViewModel {
    private MutableLiveData<List<Question>> questions;
    public LiveData<List<Question>> getQuestions() {
        if (questions == null) {
            questions = new MutableLiveData<List<Question>>();
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

        Call<List<Question>> repos = service.listRepos();

        List<Question> listOfQuestions;

        repos.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                questions.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                Log.d("Error acceso datos", t.getMessage());
            }
        });


    }
}