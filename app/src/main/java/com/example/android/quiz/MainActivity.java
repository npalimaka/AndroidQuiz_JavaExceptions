package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //right answer for first question
    @BindView(R.id.first_answerB)
    RadioButton first_answerB;
    //for question two
    @BindView(R.id.second_answerA)
    CheckBox second_answerA;
    @BindView(R.id.second_answerB)
    CheckBox second_answerB;
    @BindView(R.id.second_answerC)
    CheckBox second_answerC;
    //for question three
    @BindView(R.id.third_answer)
    EditText third_answer;
    //question four
    @BindView(R.id.fourth_answerA)
    CheckBox fourth_answerA;
    @BindView(R.id.fourth_answerB)
    CheckBox fourth_answerB;
    //question five
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
       // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        ButterKnife.bind(this);
    }

    public int countScore() {
        int score = 0;
        if(first_answerB.isChecked()){
            score += 1;
        }
        if(second_answerA.isChecked() && second_answerB.isChecked() && second_answerC.isChecked()){
            score += 1;
        }
        if (third_answer.getText().toString().equals("throws")) {
            score += 1;
        }
        if(fourth_answerA.isChecked() && fourth_answerB.isChecked()){
            score += 1;
        }
        if(fifth_answerA.isChecked()){
            score += 1;
        }
        if(sixth_answer.getText().toString().equals("throw")){
            score += 1;
        }
        if(seventh_answerA.isChecked() && seventh_answerD.isChecked()){
            score += 1;
        }
        if(eighth_answerD.isChecked()){
            score += 1;
        }
        if(ninth_answerA.isChecked()){
            score += 1;
        }
        if(tenth_answerC.isChecked()){
            score += 1;
        }
        return score;

    }
    @OnClick(R.id.submit_button)
    public void submit(){
        Toast.makeText(this, "Your score: " + countScore() + "/10", Toast.LENGTH_SHORT).show();
    }
}
