package com.example.android.quiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {

    private int score;
    //right answers for all questions
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public int countScore() {
        score = 0;
        correctRadioButtonAnswerCheck(first_answerB);
        if(second_answerA.isChecked() && second_answerB.isChecked() && second_answerC.isChecked()){
            score += 1;
        }
        if (third_answer.getText().toString().equals("throws")) {
            score += 1;
        }
        if(fourth_answerA.isChecked() && fourth_answerB.isChecked()){
            score += 1;
        }
        correctRadioButtonAnswerCheck(fifth_answerA);
        if(sixth_answer.getText().toString().equals("throw")){
            score += 1;
        }
        if(seventh_answerA.isChecked() && seventh_answerD.isChecked()){
            score += 1;
        }
        correctRadioButtonAnswerCheck(eighth_answerD);
        correctRadioButtonAnswerCheck(ninth_answerA);
        correctRadioButtonAnswerCheck(tenth_answerC);

        return score;
    }

    private void correctRadioButtonAnswerCheck(RadioButton radioButton) {

        if(radioButton.isChecked()){
            score += 1;
            radioButton.setTextColor(Color.GREEN);
        }
    }

    @OnClick(R.id.submit_button)
    public void submit(){
        Toast.makeText(this, "Your score: " + countScore() + "/10", Toast.LENGTH_SHORT).show();
    }
}
