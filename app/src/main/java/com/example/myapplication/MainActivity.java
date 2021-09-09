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

import com.example.myapplication.classes.WidgetController;

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
        WidgetController   widgetController = new WidgetController(  button_insert,
                 text_name,
                 text_age,
                text_hobby,
                 text_location,
                 cardView1,  cardReset,
                 editText1, relative_input);
        widgetController.setVisibilityToGone();
   cardReset.setOnClickListener(this);
   button_insert.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v==button_insert){
            new WidgetController(button_insert,
                    text_name,
                    text_age,
                    text_hobby,
                    text_location,
                    cardView1,  cardReset,
                    editText1, relative_input).setFunctionForButton_Insert();
        }
        if(v==cardReset){
            new WidgetController(button_insert,
                    text_name,
                    text_age,
                    text_hobby,
                    text_location,
                    cardView1,  cardReset,
                    editText1, relative_input).setFunctionForReset_button();
        }

    }
}