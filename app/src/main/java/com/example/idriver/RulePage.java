package com.example.idriver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.makeText;

public class RulePage extends AppCompatActivity {
   private int my_counter = 0;
    Button answer1, answer2, answer3, answer4;
    TextView score, question;
    private QuestionsRule mQuestions =new QuestionsRule();
    private String mAnswer;
    private  int mScore =0;
    private int mQuestionLength= mQuestions.mQuestions.length;
    Random r;
    Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule_page);
        r= new Random();

        answer1=(Button)findViewById(R.id.answer1);
        answer2=(Button)findViewById(R.id.answer2);
        answer3=(Button)findViewById(R.id.answer3);
        answer4=(Button)findViewById(R.id.answer4);


        score=(TextView)findViewById(R.id.score);
        question=(TextView)findViewById(R.id.question);
        score.setText("Score: "+ mScore+"/"+15);


        updateQuestion(r.nextInt(mQuestionLength));

          answer1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (answer1.getText() == mAnswer) {
                      mScore++;
                      makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
                      score.setText("Score: " + mScore+"/"+15);
                      updateQuestion(r.nextInt(mQuestionLength));
                      if(my_counter>13){
                          gameOver();
                      }

                  } else {makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                      if(my_counter>13){
                          gameOver();
                      }

                      updateQuestion(r.nextInt(mQuestionLength));
                  }
                  my_counter++;

              }
          });
          answer2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (answer2.getText() == mAnswer) {
                      mScore++;
                      makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
                      score.setText("Score: " + mScore+"/"+15);
                      updateQuestion(r.nextInt(mQuestionLength));
                      if(my_counter>13){
                          gameOver();
                      }

                  } else {
                      makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                      updateQuestion(r.nextInt(mQuestionLength));
                      if(my_counter>13){
                          gameOver();
                      }
                  }
                  my_counter++;
              }
          });
          answer3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (answer3.getText() == mAnswer) {
                      mScore++;
                      makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
                      score.setText("Score: " + mScore+"/"+15);
                      updateQuestion(r.nextInt(mQuestionLength));
                      if(my_counter>13){
                          gameOver();
                      }

                  } else {
                      makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                      updateQuestion(r.nextInt(mQuestionLength));
                      if(my_counter>13){
                          gameOver();
                      }
                  }
                  my_counter++;
              }
          });
          answer4.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (answer4.getText() == mAnswer) {
                      mScore++;
                      makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
                      score.setText("Score: " + mScore+"/"+15);
                      updateQuestion(r.nextInt(mQuestionLength));
                      if(my_counter>13){
                          gameOver();
                      }

                  } else {
                      makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                      updateQuestion(r.nextInt(mQuestionLength));
                      if(my_counter>13){
                          gameOver();
                      }
                  }

              my_counter++;
              }
          });


    }

    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer=mQuestions.getCorrectAnswer(num);
    }
    private void gameOver(){
       AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(RulePage.this);
        alertDialogBuilder

                .setMessage("Game Over! Your score is "+mScore +"/"+15+" points.")
                .setCancelable(false)

                .setPositiveButton("Start Again" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), RulePage.class));

                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                           finish();
                    }
                });
        AlertDialog alertDialog =alertDialogBuilder.create();
        alertDialog.show();


    }


}
