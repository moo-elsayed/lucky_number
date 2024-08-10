package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class target extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        textView = findViewById(R.id.hello);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        Random rand = new Random();
        int num = rand.nextInt(100);
        textView2 = findViewById(R.id.res);
        textView2.setText(String.valueOf(num));
        button = findViewById(R.id.button2);
        button.setOnClickListener(
                v -> {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "look " + name + "'s lucky number is " + String.valueOf(num) + " !");
                    sendIntent.setType("text/plain");
                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                }
        );
    }
}