package com.example.fibb1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CardViewActivity extends Activity {

    TextView term;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_activity);
        term = findViewById(R.id.term);
        term.setText("1");
    }
}