/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.babybookcase;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GridView gridView = (GridView)findViewById(R.id.gridview);
    final BookAdapter bookAdapter = new BookAdapter(this, books);
    gridView.setAdapter(bookAdapter);

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Book book = books[position];
        book.toggleFavorite();
        bookAdapter.notifyDataSetChanged();
      }
    });
  }

  private Book[] books = {
    new Book("ABC: An Amazing Alphabet Book!", "Dr. Seuss", R.drawable.abc),
    new Book("Are You My Mother", "Dr. Seuss", R.drawable.areyoumymother),
    new Book("Where is Baby's Belly Button?", "Karen Katz", R.drawable.whereisbabysbellybutton),
    new Book("On The Night You Were Born", "Nancy Tillman", R.drawable.onthenightyouwereborn),
    new Book("Hand Hand Fingers Thumb", "Dr. Seuss", R.drawable.handhandfingersthumb),
    new Book("The Very Hungry Caterpillar", "Eric Carle", R.drawable.theveryhungrycaterpillar),
    new Book("The Going To-Bed Book", "Sandra Boynton", R.drawable.thegoingtobedbook),
    new Book("Oh Baby Go Baby", "Dr. Seuss", R.drawable.ohbabygobaby),
    new Book("The Tooth Book", "Dr. Seuss", R.drawable.thetoothbook),
    new Book("One Fish, Two Fish, Red Fish, Blue Fish", "Dr. Seuss", R.drawable.onefish)
  };

  private class BookAdapter extends BaseAdapter {
    private final Context mContext;
    private final Book[] books;

    public BookAdapter(Context context, Book[] books) {
      this.mContext = context;
      this.books = books;
    }

    @Override
    public int getCount() {
      return books.length;
    }

    @Override
    public long getItemId(int position) {
      return 0;
    }

    @Override
    public Object getItem(int position) {
      return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      Book book = books[position];

      // standard implementation
//      if (convertView == null) {
//        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
//        convertView = layoutInflater.inflate(R.layout.linearlayout_book, null);
//      }
//
//      ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_book);
//      TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
//      TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
//
//      imageView.setImageResource(book.getImageResource());
//      nameTextView.setText(book.getName());
//      authorTextView.setText(book.getAuthor());

      // view holder pattern
      if (convertView == null) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.linearlayout_book, null);

        ImageView imageViewCoverArt = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
        TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
        ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);

        ViewHolder viewHolder = new ViewHolder(nameTextView, authorTextView, imageViewCoverArt, imageViewFavorite);
        convertView.setTag(viewHolder);
      }

      ViewHolder viewHolder = (ViewHolder)convertView.getTag();
      viewHolder.imageViewCoverArt.setImageResource(book.getImageResource());
      viewHolder.nameTextView.setText(book.getName());
      viewHolder.authorTextView.setText(book.getAuthor());
      viewHolder.imageViewFavorite.setImageResource(book.getIsFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled);

      return convertView;
    }

    private class ViewHolder {
      private final TextView nameTextView;
      private final TextView authorTextView;
      private final ImageView imageViewCoverArt;
      private final ImageView imageViewFavorite;

      public ViewHolder(TextView nameTextView, TextView authorTextView, ImageView imageViewCoverArt, ImageView imageViewFavorite) {
        this.nameTextView = nameTextView;
        this.authorTextView = authorTextView;
        this.imageViewCoverArt = imageViewCoverArt;
        this.imageViewFavorite = imageViewFavorite;
      }

    }
  }
}
