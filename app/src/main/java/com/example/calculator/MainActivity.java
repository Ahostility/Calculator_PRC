package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Calc culc;
    private TextView text_output;
    private EditText editText;
    private String input_str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        culc = new Calc();
        editText = findViewById(R.id.editText);
        text_output = findViewById(R.id.text);

        View.OnClickListener ClickPlus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence cs = editText.getText();
                input_str = String.valueOf(cs);
                culc.onClickPlus(input_str);
                text_output.setText(culc.getResult());
                editText.setText(culc.ResultOutput());
            }
        };

        View.OnClickListener ClickMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence cs = editText.getText();
                input_str = String.valueOf(cs);
                culc.onClickMinus(input_str);
                text_output.setText(culc.getResult());
                editText.setText(culc.ResultOutput());
            }
        };

        View.OnClickListener ClickUmnojit = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence cs = editText.getText();
                input_str = String.valueOf(cs);
                culc.onClickUmnojit(input_str);
                text_output.setText(culc.getResult());
                editText.setText(culc.ResultOutput());
            }
        };

        View.OnClickListener ClickRazdelit = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence cs = editText.getText();
                input_str = String.valueOf(cs);
                culc.onClickRazdelit(input_str);
                text_output.setText(culc.getResult());
                editText.setText(culc.ResultOutput());
            }
        };
        findViewById(R.id.plus).setOnClickListener(ClickPlus);
        findViewById(R.id.minus).setOnClickListener(ClickMinus);
        findViewById(R.id.umnojit).setOnClickListener(ClickUmnojit);
        findViewById(R.id.razdelit).setOnClickListener(ClickRazdelit);
    }
}
