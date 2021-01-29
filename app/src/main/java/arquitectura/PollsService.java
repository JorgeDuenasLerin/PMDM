package arquitectura;

import java.util.List;

import arquitectura.paginación.QuestionPaginated;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PollsService {

    @GET("polls/api/question/")
    Call<List<Question>> listRepos();

    /*
    @GET("polls/api/question/")
    Call<QuestionPaginated> listRepos();
    */
}
