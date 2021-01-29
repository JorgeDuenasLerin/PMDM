package org.duenaslerin.pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import arquitectura.Question;
import arquitectura.paginación.QuestionPaginatedListViewModel;

public class U11_ArquitecturaPrincipal extends AppCompatActivity {

    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u11__arquitectura_principal);
        tx = findViewById(R.id.txInfo);


        QuestionPaginatedListViewModel model = new ViewModelProvider(this).get(QuestionPaginatedListViewModel.class);
        model.getQuestions().observe(this, questions -> {


            ArrayList<Question> questResult = questions.results;

            String s = "";
            for(Question q: questResult){
                s += q.question_text;
            }
            tx.setText(s);
        });
    }

    public void onPetición(View v){
        tx.setText("Hola");
    }
}