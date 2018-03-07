package com.example.android.quiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    //right answers for all questions:
    @BindView(R.id.first_answerB)
    RadioButton first_answerB;
    @BindView(R.id.second_answerA)
    CheckBox second_answerA;
    @BindView(R.id.second_answerB)
    CheckBox second_answerB;
    @BindView(R.id.second_answerC)
    CheckBox second_answerC;
    @BindView(R.id.third_answer)
    EditText third_answer;
    @BindView(R.id.fourth_answerA)
    CheckBox fourth_answerA;
    @BindView(R.id.fourth_answerB)
    CheckBox fourth_answerB;
    @BindView(R.id.fifth_answerA)
    RadioButton fifth_answerA;
    @BindView(R.id.sixth_answer)
    EditText sixth_answer;
    @BindView(R.id.seventh_answerA)
    CheckBox seventh_answerA;
    @BindView(R.id.seventh_answerD)
    CheckBox seventh_answerD;
    @BindView(R.id.eighth_answerD)
    RadioButton eighth_answerD;
    @BindView(R.id.ninth_answerA)
    RadioButton ninth_answerA;
    @BindView(R.id.tenth_answerC)
    RadioButton tenth_answerC;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private int countScore() {
        score = 0;
        correctRadioButtonAnswerCheck(first_answerB);
        if (second_answerA.isChecked() && second_answerB.isChecked() && second_answerC.isChecked()) {
            score += 1;
            if (second_answerA.isChecked()) {
                second_answerA.setTextColor(Color.GREEN);
            }
            if (second_answerB.isChecked()) {
                second_answerB.setTextColor(Color.GREEN);
            }
            if (second_answerC.isChecked()) {
                second_answerC.setTextColor(Color.GREEN);
            }
        }
        if (third_answer.getText().toString().equals("throws")) {
            score += 1;
            third_answer.setTextColor(Color.GREEN);
        } else {
            third_answer.setTextColor(Color.RED);
        }
        if (fourth_answerA.isChecked() && fourth_answerB.isChecked()) {
            score += 1;
            if (fourth_answerA.isChecked()) {
                fourth_answerA.setTextColor(Color.GREEN);
            }
            if (fourth_answerB.isChecked()) {
                fourth_answerB.setTextColor(Color.GREEN);
            }
        }
        correctRadioButtonAnswerCheck(fifth_answerA);
        if (sixth_answer.getText().toString().equals("throw")) {
            score += 1;
            sixth_answer.setTextColor(Color.GREEN);
        } else {
            sixth_answer.setTextColor(Color.RED);
        }
        if (seventh_answerA.isChecked() && seventh_answerD.isChecked()) {
            score += 1;
            if (seventh_answerA.isChecked()) {
                seventh_answerA.setTextColor(Color.GREEN);
            }
            if (seventh_answerD.isChecked()) {
                seventh_answerD.setTextColor(Color.GREEN);
            }
        }
        correctRadioButtonAnswerCheck(eighth_answerD);
        correctRadioButtonAnswerCheck(ninth_answerA);
        correctRadioButtonAnswerCheck(tenth_answerC);

        return score;
    }

    private void correctRadioButtonAnswerCheck(RadioButton radioButton) {

        if (radioButton.isChecked()) {
            score += 1;
            radioButton.setTextColor(Color.GREEN);
        }
    }

    @OnClick(R.id.submit_button)
    public void submit() {
        Toast.makeText(this, "Your score: " + countScore() + "/10", Toast.LENGTH_SHORT).show();
    }
}
