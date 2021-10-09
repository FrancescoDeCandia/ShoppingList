package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button item1;
    private Button item2;
    private Button item3;
    private Button item4;
    private Button item5;
    private Button item6;

    public static final String EXTRA_MESSAGE =
            "com.example.shoppinglistapp.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        item1 = findViewById(R.id.button_1);
        item2 = findViewById(R.id.button_2);
        item3 = findViewById(R.id.button_3);
        item4 = findViewById(R.id.button_4);
        item5 = findViewById(R.id.button_5);
        item6 = findViewById(R.id.button_6);
    }

    public void returnReply(View view) {
        Intent replyIntent = new Intent();
        switch (view.getId()) {
            case R.id.button_1:
                String item1 = getString(R.string.button1);
                replyIntent.putExtra(EXTRA_MESSAGE, item1);
                break;
            case R.id.button_2:
                String item2 = getString(R.string.button2);
                replyIntent.putExtra(EXTRA_MESSAGE, item2);
                break;
            case R.id.button_3:
                String item3 = getString(R.string.button3);
                replyIntent.putExtra(EXTRA_MESSAGE, item3);
                break;

            case R.id.button_4:
                String item4 = getString(R.string.button4);
                replyIntent.putExtra(EXTRA_MESSAGE, item4);
                break;
            case R.id.button_5:
                String item5 = getString(R.string.button5);
                replyIntent.putExtra(EXTRA_MESSAGE, item5);
                break;
            case R.id.button_6:
                String item6 = getString(R.string.button6);
                replyIntent.putExtra(EXTRA_MESSAGE, item6);
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        setResult(RESULT_OK,replyIntent);
        finish();
    }
}