package com.example.lesson21;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    protected TextView textView;
    protected TextView textForInputName;
    protected TextView textForInputNumber;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.name);



        textForInputName = findViewById(R.id.textView);
        textForInputNumber = findViewById(R.id.name);



        ImageButton btn = findViewById(R.id.add);


        Intent intent = getIntent();
        if (intent.hasExtra("1")) {
            String tex = intent.getStringExtra("1");
            textForInputName.setText("имя: " + tex);
        }
        if (intent.hasExtra("2")) {
            String text = intent.getStringExtra("2");
            textForInputNumber.setText("номер: "+  text);


        }
        btn.setOnClickListener(v -> {
            Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            ImageView imageView = findViewById(R.id.imageView2);

            Bitmap bit = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            ByteArrayOutputStream streamy = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG, 0, streamy);
            byte[] photo = streamy.toByteArray();
            ContentValues values = new ContentValues();
            values.put(ContactsContract.CommonDataKinds.Photo.PHOTO, photo);
//
//            int mPhotoWidth = bitmap.getWidth();
//            int mPhotoHeight = bitmap.getHeight();
//            imageView.setImageBitmap(bitmap);
//
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 5000, baos);
//            byte[] imageInByte = baos.toByteArray();



            contactIntent
                        .putExtra(String.valueOf(ContactsContract.Data.CONTENT_URI), values);
//                      .putExtra(ContactsContract.CommonDataKinds.Photo.PHOTO, photo );
//                    .putExtra(ContactsContract.Intents.Insert.NAME, textForInputName.getText().toString().substring(3) )
//                    .putExtra(ContactsContract.Intents.Insert.PHONE, textForInputNumber.getText().toString());


            startActivityForResult(contactIntent, 1);
        });

        textView.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity2.class);
            startActivity(intent1);
        });


    }
    public byte[] getByteArrayfromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 1500, bos);
        return bos.toByteArray();
    }


}