package com.github.techcamp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.techcamp.BookDetailsActivity;
import com.github.techcamp.Models.BookModel;
import com.github.techcamp.R;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {


    private ArrayList<BookModel> books;
    private Context mContext;

    public BooksAdapter(ArrayList<BookModel> books, Context mContext) {
        this.books = books;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bookView = LayoutInflater.from(mContext).inflate(R.layout.book_list, parent, false);
        return new BooksViewHolder(bookView);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {


        BookModel book = books.get(position);

        holder.bookTitle.setText(books.get(position).getTitle());
        holder.bookImageview.setImageResource(book.getThumbnail());

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder {

        ImageView bookImageview;
        TextView bookTitle;
        CardView mCardView;


        BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImageview = itemView.findViewById(R.id.book_img);
            bookTitle = itemView.findViewById(R.id.book_title);
            mCardView = itemView.findViewById(R.id.card_view);

            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    BookModel book = books.get(position);

                    Intent bookIntent = new Intent(mContext, BookDetailsActivity.class);
                    bookIntent.putExtra("Title", book.getTitle());
                    bookIntent.putExtra("Category", book.getCategory());
                    bookIntent.putExtra("Description", book.getDescription());
                    bookIntent.putExtra("Image", book.getThumbnail());

                    mContext.startActivity(bookIntent);
                    Toast.makeText(mContext, book.getTitle(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
