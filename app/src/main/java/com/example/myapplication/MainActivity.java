package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button button_insert;
private TextView text_name;
private TextView text_age;
private TextView text_hobby;
private TextView text_location;
private CardView cardView1;
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
   relative_input=findViewById(R.id.relative_input);
   setVisibilityToGone();
   button_insert.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if(editText1.getText().toString().isEmpty()){

               Toast.makeText(getApplicationContext(), "Field can't be empty!", Toast.LENGTH_SHORT).show();
               return;
           }
           cardView1.setVisibility(View.VISIBLE);
           if (text_name.getVisibility() == View.GONE) {
               text_name.setVisibility(View.VISIBLE);
               return;
           }

           if (text_age.getVisibility() == View.GONE) {
               text_age.setVisibility(View.VISIBLE);
               return;
           }


          if(text_location.getVisibility()==View.GONE){
              text_location.setVisibility(View.VISIBLE);
              return;

          }
           if (text_hobby.getVisibility() == View.GONE) {
               text_hobby.setVisibility(View.VISIBLE);
               relative_input.setVisibility(View.GONE);
           }

       }
   });
    }

    private void setVisibilityToGone() {
        text_name.setVisibility(View.GONE);
        text_age.setVisibility(View.GONE);
        text_location.setVisibility(View.GONE);

        text_hobby.setVisibility(View.GONE);

        cardView1.setVisibility(View.GONE);
    }
}