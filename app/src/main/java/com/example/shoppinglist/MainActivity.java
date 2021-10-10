package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private TextView mReplyTextView1;
    private TextView mReplyTextView2;
    private TextView mReplyTextView3;
    private TextView mReplyTextView4;
    private TextView mReplyTextView5;
    private TextView mReplyTextView6;
    private EditText mLocationEditText;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReplyTextView1 = findViewById(R.id.show_item1);
        mReplyTextView2 = findViewById(R.id.show_item2);
        mReplyTextView3 = findViewById(R.id.show_item3);
        mReplyTextView4 = findViewById(R.id.show_item4);
        mReplyTextView5 = findViewById(R.id.show_item5);
        mReplyTextView6 = findViewById(R.id.show_item6);
        mLocationEditText = findViewById(R.id.location_edittext);

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                mReplyTextView1.setText(savedInstanceState.getString("reply_text1"));
                mReplyTextView2.setText(savedInstanceState.getString("reply_text2"));
                mReplyTextView3.setText(savedInstanceState.getString("reply_text3"));
                mReplyTextView4.setText(savedInstanceState.getString("reply_text4"));
                mReplyTextView5.setText(savedInstanceState.getString("reply_text5"));
                mReplyTextView6.setText(savedInstanceState.getString("reply_text6"));
                mReplyTextView1.setVisibility(View.VISIBLE);
                mReplyTextView2.setVisibility(View.VISIBLE);
                mReplyTextView3.setVisibility(View.VISIBLE);
                mReplyTextView4.setVisibility(View.VISIBLE);
                mReplyTextView5.setVisibility(View.VISIBLE);
                mReplyTextView6.setVisibility(View.VISIBLE);
            }
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button \"ADD ITEM\" clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);

                if (mReplyTextView1.getText().toString().isEmpty()) {
                    mReplyTextView1.setVisibility(View.VISIBLE);
                    mReplyTextView1.setText(reply);
                } else if (mReplyTextView2.getText().toString().isEmpty()) {
                    mReplyTextView2.setVisibility(View.VISIBLE);
                    mReplyTextView2.setText(reply);
                } else if (mReplyTextView3.getText().toString().isEmpty()) {
                    mReplyTextView3.setVisibility(View.VISIBLE);
                    mReplyTextView3.setText(reply);
                } else if (mReplyTextView4.getText().toString().isEmpty()) {
                    mReplyTextView4.setVisibility(View.VISIBLE);
                    mReplyTextView4.setText(reply);
                } else if (mReplyTextView5.getText().toString().isEmpty()) {
                    mReplyTextView5.setVisibility(View.VISIBLE);
                    mReplyTextView5.setText(reply);
                } else if (mReplyTextView6.getText().toString().isEmpty()) {
                    mReplyTextView6.setVisibility(View.VISIBLE);
                    mReplyTextView6.setText(reply);
                } else Log.d(LOG_TAG, "Non puoi più aggiungere altri items!");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyTextView1.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text1", mReplyTextView1.getText().toString());
            outState.putString("reply_text2", mReplyTextView2.getText().toString());
            outState.putString("reply_text3", mReplyTextView3.getText().toString());
            outState.putString("reply_text4", mReplyTextView4.getText().toString());
            outState.putString("reply_text5", mReplyTextView5.getText().toString());
            outState.putString("reply_text6", mReplyTextView6.getText().toString());
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(intent);
    }
}