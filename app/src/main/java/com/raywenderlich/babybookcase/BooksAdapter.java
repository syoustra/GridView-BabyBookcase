/*
 * PROJECT LICENSE:
 *
 * This project has been completed by Stephanie Youstra as part of the Udacity Android Developer Nanodegree.
 * Feel free to view this as a reference point, but remember Udacity's Honor Code requiring that submissions be original work. Any liability for the consequences of plagiarism lies solely with the "borrower".
 *
 * Copyright (c) 2018 ~ Stephanie Youstra.
 */

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
