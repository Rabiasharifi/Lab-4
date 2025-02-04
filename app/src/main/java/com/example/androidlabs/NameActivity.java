package com.example.androidlabs;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        TextView textViewWelcome = findViewById(R.id.textViewWelcome);
        Button buttonDontCallMeThat = findViewById(R.id.buttonDontCallMeThat);
        Button buttonThankYou = findViewById(R.id.buttonThankYou);

        // Retrieve user's name from intent
        String userName = getIntent().getStringExtra("userName");
        textViewWelcome.setText("Welcome " + userName + "!");

        buttonDontCallMeThat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });

        buttonThankYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
    }
}
