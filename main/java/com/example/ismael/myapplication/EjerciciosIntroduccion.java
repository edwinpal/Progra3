package com.example.ismael.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class EjerciciosIntroduccion extends AppCompatActivity {

    private int idsRgroup[] = {
            R.id.rd1, R.id.rd2, R.id.rd3, R.id.rd4
    };
    private int correct_answer;
    private int current_question;
    private String[] all_questions;
    private boolean[] answer_is_correct;
    private int[] answer;
    private TextView text_question;
    private RadioGroup group;
    private Button btn_next, btn_prev;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_introduccion);

        text_question = (TextView) findViewById(R.id.txtPreguntasIntr);
        group = (RadioGroup) findViewById(R.id.radiogroupInt);
        btn_next = (Button) findViewById(R.id.btnSiguientePreIntr);
        btn_prev = (Button) findViewById(R.id.btn_prev);

        all_questions = getResources().getStringArray(R.array.all_questions);
        answer_is_correct = new boolean[all_questions.length];
        answer = new int[all_questions.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        current_question = 0;
        showQuestion();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (current_question < all_questions.length-1) {
                    current_question++;
                    showQuestion();
                } else {
                    int correctas = 0, incorrectas = 0;
                    for (boolean b : answer_is_correct) {
                        if (b) correctas++;
                        else incorrectas++;
                    }
                    String resultado =
                            String.format(Locale.getDefault(), "Correctas: %d -- Incorrectas: %d", correctas, incorrectas);

                    Toast.makeText(EjerciciosIntroduccion.this, resultado, Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (current_question > 0) {
                    current_question--;
                    showQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        int id = group.getCheckedRadioButtonId();
        int ans = -1;
        for (int i = 0; i < idsRgroup.length; i++) {
            if (idsRgroup[i] == id) {
                ans = i;
            }
        }
        answer_is_correct[current_question] = (ans == correct_answer);
        answer[current_question] = ans;
    }

    private void showQuestion() {
        String qq = all_questions[current_question];
        String[] parts = qq.split(";");

        group.clearCheck();

        text_question.setText(parts[0]);
        for (int i = 0; i < idsRgroup.length; i++) {
            RadioButton rb = (RadioButton) findViewById(idsRgroup[i]);
            String ans = parts[i+1];
            if (ans.charAt(0) == '*') {
                correct_answer = i;
                ans = ans.substring(1);
            }
            rb.setText(ans);
            if (answer[current_question] == i) {
                rb.setChecked(true);
            }
        }
        if (current_question == 0) {
            btn_prev.setVisibility(View.GONE);
        } else {
            btn_prev.setVisibility(View.VISIBLE);
        }
        if (current_question == all_questions.length-1) {
            btn_next.setText(R.string.finish);
        } else {
            btn_next.setText(R.string.next);
        }

    }
}
