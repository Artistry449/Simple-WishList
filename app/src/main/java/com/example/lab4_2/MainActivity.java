package com.example.lab4_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import data.DatabaseHandler;
import model.MyWish;

public class MainActivity extends AppCompatActivity {
    private EditText title;
    private EditText content;
    private Button saveButton;
    private DatabaseHandler dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dba = new DatabaseHandler(this);
        title = (EditText) findViewById(R.id.titleEditText);
        content = (EditText) findViewById(R.id.wishEditText);
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();
            }
        });
    }
    private void saveToDB() {
        MyWish wish = new MyWish();
        wish.setTitle(title.getText().toString().trim());
        wish.setContent(content.getText().toString().trim()); dba.addWishes(wish);
        dba.close();
        title.setText(""); content.setText("");
        Intent i = new Intent(MainActivity.this, DisplayWishesActivity.class); startActivity(i);
    }
}