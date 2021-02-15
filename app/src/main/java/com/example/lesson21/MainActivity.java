package com.example.lesson21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text3);
        TextView text1 = findViewById(R.id.textView);
        TextView text2 = findViewById(R.id.textView2);
        ImageButton btn = findViewById(R.id.phone);
        textView.setOnClickListener(this);


            Intent intent = getIntent();
            if(intent.hasExtra("1")){
                String tex = intent.getStringExtra("1");
                text2.setText(tex);
            }
            if (intent.hasExtra("2")){
                String text = intent.getStringExtra("2");
                text1.setText(text);


            }

    }

    @Override
    public void onClick(View v) {
        String string = "tel: +996709089032";
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


}