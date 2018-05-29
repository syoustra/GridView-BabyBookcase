package com.raywenderlich.babybookcase;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BooksAdapter extends BaseAdapter {

    private final Context mContext;
    private final Book[] books;

    public BooksAdapter (Context context, Book[] books) {
        this.mContext = context;
        this.books = books;
    }


    @Override
    public int getCount() {
        return books.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;
    }


}
