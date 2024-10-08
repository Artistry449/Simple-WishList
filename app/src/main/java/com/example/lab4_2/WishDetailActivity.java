package com.example.lab4_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import data.DatabaseHandler;

public class WishDetailActivity extends AppCompatActivity {
    private TextView title, date, content;
    private Button deleteButton;
    DisplayWishesActivity dwa = new DisplayWishesActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_detail);
        DisplayWishesActivity dwa = new DisplayWishesActivity();

        title = (TextView) findViewById(R.id.detailsTitle);
        date = (TextView) findViewById(R.id.detailsDateText);
        content = (TextView) findViewById(R.id.detailsTextView);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title.setText(extras.getString("title"));
            date.setText("Created: " + extras.getString("date"));
            content.setText(" \" " + extras.getString("content") + " \" ");
            final int id = extras.getInt("id");

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        DatabaseHandler dba = new DatabaseHandler(getApplicationContext());
                        dba.deleteWish(id);
                        Toast.makeText(getApplicationContext(), "Wish Deleted!", Toast.LENGTH_LONG).show();

                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("wishDeleted", true);
                        setResult(RESULT_OK, resultIntent);

                        finish();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error Deleting Wish!", Toast.LENGTH_LONG).show();
                        Log.d("DELETE CLICK", "onDeleteClick: " + e);
                    }
                }
            });

        }
    }
}
