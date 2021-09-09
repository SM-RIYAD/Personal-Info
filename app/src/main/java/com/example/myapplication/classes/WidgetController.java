package com.example.myapplication.classes;
import android.net.wifi.aware.PublishConfig;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import java.text.MessageFormat;
public class WidgetController {
    public Button button_insert;
    public TextView text_name;
    public TextView text_age;
    public TextView text_hobby;
    public TextView text_location;
    public CardView cardView1,cardReset;
    public EditText editText1;
    public RelativeLayout relative_input;
    public WidgetController(Button button_insert,
                            TextView text_name,
                            TextView text_age,
                            TextView text_hobby,
                            TextView text_location,
                            CardView cardView1, CardView cardReset,
                            EditText editText1, RelativeLayout relative_input){
         this.button_insert=button_insert;
        this.text_name=text_name;
        this.text_age=text_age;
        this.text_hobby=text_hobby;
       this.text_location=text_location;
        this.cardView1=cardView1;
        this.cardReset=cardReset;
        this.editText1=editText1;
       this.relative_input=relative_input;

    }
    public void setVisibilityToGone() {
        text_name.setVisibility(View.GONE);
        text_age.setVisibility(View.GONE);
        text_location.setVisibility(View.GONE);
        text_hobby.setVisibility(View.GONE);
        cardView1.setVisibility(View.GONE);
    }
    public void setFunctionForButton_Insert(){
        if(editText1.getText().toString().isEmpty()){

            Toast.makeText(text_name.getContext(), "Field can't be empty!", Toast.LENGTH_SHORT).show();
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
     public void setFunctionForReset_button(){

         editText1.setText("");
         editText1.setInputType(InputType.TYPE_CLASS_TEXT);
         editText1.setHint("Enter name.");
         cardReset.setVisibility(View.GONE);
         relative_input.setVisibility(View.VISIBLE);
         setVisibilityToGone();


     }



}
