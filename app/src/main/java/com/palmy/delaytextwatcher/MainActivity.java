package com.palmy.delaytextwatcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edittext);
        mTextView = findViewById(R.id.textview);
        mEditText.addTextChangedListener(new DelayTextWatcher(new DelayTextWatcher.SearchCallback() {
            @Override
            public void getKeywords(String keywords) {
                mTextView.setText(keywords);
            }
        }));
    }
}
