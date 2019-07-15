package com.github.techcamp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.techcamp.Adapters.BooksAdapter;
import com.github.techcamp.Models.BookModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BookModel> books = new ArrayList<>();
    private BooksAdapter bookAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        recyclerView = findViewById(R.id.recycler_view);

        books.add(new BookModel("Nicholas And The Wacalf", "Thieves", "Njau meets Wacalf in the cattle dip", R.drawable.hediedwith));
        books.add(new BookModel("Invested in Thieves", "Kings", "Drama  the cow shed", R.drawable.mariasemples));
        books.add(new BookModel("Stolen From The Righteous in Prison", "Religion", "Tithe drama with potassium hydroxide", R.drawable.privacy));
        books.add(new BookModel("Tony The Pot Berry", "Kids", "Candy crush reunion", R.drawable.privacy));
        books.add(new BookModel("The Comic Viewers", "Jokers Pride", "The reunion of TMNT", R.drawable.themartian));
        books.add(new BookModel("Software Developer In Ndaiya", "Kids", "Passion and un-roadworthy teams fid their git truck", R.drawable.thevigitarian));
        books.add(new BookModel("Pater the Weed Sniffer", "Joking Aside", "The smoker and the chimney", R.drawable.thewildrobot));
        books.add(new BookModel("Njau the Cow's Male Version", "Love For Animals", "after tick evasion", R.drawable.thewildrobot));


        bookAdapter = new BooksAdapter(books, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(bookAdapter);
    }
}
