package com.github.techcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailsActivity extends AppCompatActivity {
    private TextView myTitle, myCategory, myDescription;
    private ImageView myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        init();


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            int coverImage = extras.getInt("Image");
            String title = extras.getString("Title");
            String category = extras.getString("Category");
            String description = extras.getString("Description");

            myTitle.setText(title);
            myCategory.setText(category);
            myImage.setImageResource(coverImage);
            myDescription.setText(description);

        }
    }

    private void init() {
        myTitle = findViewById(R.id.title);
        myCategory = findViewById(R.id.category);
        myDescription = findViewById(R.id.description);
        myImage = findViewById(R.id.cover_img);
    }

    public void review(View view) {


        Intent moveToHome = new Intent(BookDetailsActivity.this, MainActivity.class);
        startActivity(moveToHome);
    }
}
