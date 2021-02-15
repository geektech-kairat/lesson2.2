package com.example.lesson21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button editText = findViewById(R.id.aaa);
        EditText editText1 = findViewById(R.id.text0);
        EditText editText2 = findViewById(R.id.text01);
        editText.setOnClickListener(v -> {
            String string1 = editText1.getText().toString();
            String string2 = editText2.getText().toString();
            int in = Integer.parseInt(string2);
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            intent
                    .putExtra("1", string1)
                    .putExtra("2", string2);
            startActivity(intent);
//            Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
//            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
//            contactIntent
//                    .putExtra(ContactsContract.Intents.Insert.NAME, string1)
//                    .putExtra(ContactsContract.Intents.Insert.PHONE, string2);
//            startActivityForResult(contactIntent, 1);
        });

    }
    }
