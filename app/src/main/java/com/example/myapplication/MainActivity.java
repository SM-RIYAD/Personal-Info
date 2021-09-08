package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button button_insert;
private TextView text_name;
private TextView text_age;
private TextView text_hobby;
private TextView text_location;
private CardView cardView1,cardReset;
private EditText editText1;
private RelativeLayout relative_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   text_name= findViewById(R.id.text_name);
   text_age=findViewById(R.id.text_age);
   text_hobby=findViewById(R.id.text_hobby);
   text_location=findViewById(R.id.text_location);
   button_insert = findViewById(R.id.button_insert);
   editText1=findViewById(R.id.edit_text1);
   cardView1 =findViewById(R.id.cardview1);
   cardReset =findViewById(R.id.card_reset);
   relative_input=findViewById(R.id.relative_input);
   setVisibilityToGone();
   cardReset.setOnClickListener(this);
   button_insert.setOnClickListener(this);
    }

    private void setVisibilityToGone() {
        text_name.setVisibility(View.GONE);
        text_age.setVisibility(View.GONE);
        text_location.setVisibility(View.GONE);

        text_hobby.setVisibility(View.GONE);

        cardView1.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        if(v==button_insert){

            if(editText1.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Field can't be empty!", Toast.LENGTH_SHORT).show();
                return;
            }
            cardView1.setVisibility(View.VISIBLE);
            if (text_name.getVisibility() == View.GONE) {
                ///text_name.setText(editText1.getText().toString());
                text_name.setText(MessageFormat.format("My name is {0}", editText1.getText().toString()));
                editText1.setText("");
                text_name.setVisibility(View.VISIBLE);
                editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText1.setHint("Enter age.");
                return;
            }

            if (text_age.getVisibility() == View.GONE) {
                text_age.setVisibility(View.VISIBLE);
                text_age.setText(MessageFormat.format("I am {0} years old", editText1.getText().toString()));
                editText1.setText("");
                text_age.setVisibility(View.VISIBLE);
                editText1.setInputType(InputType.TYPE_CLASS_TEXT);
                editText1.setHint("Enter location.");
                return;
            }


            if(text_location.getVisibility()==View.GONE){
                text_location.setVisibility(View.VISIBLE);
                text_location.setText(MessageFormat.format("I live in {0}", editText1.getText().toString()));
                editText1.setText("");
                text_location.setVisibility(View.VISIBLE);
                editText1.setInputType(InputType.TYPE_CLASS_TEXT);
                editText1.setHint("Enter hobby.");
                return;

            }
            if (text_hobby.getVisibility() == View.GONE) {
                text_hobby.setVisibility(View.VISIBLE);

                text_hobby.setText(MessageFormat.format("I love {0}", editText1.getText().toString()));
                editText1.setText("");


                editText1.setHint("Enter name.");
                relative_input.setVisibility(View.GONE);
                cardReset.setVisibility(View.VISIBLE);
            }



        }
        if(v==cardReset){

            setVisibilityToGone();
            editText1.setText("");
            editText1.setInputType(InputType.TYPE_CLASS_TEXT);
            editText1.setHint("Enter name.");
            cardReset.setVisibility(View.GONE);
            relative_input.setVisibility(View.VISIBLE);

        }

    }
}