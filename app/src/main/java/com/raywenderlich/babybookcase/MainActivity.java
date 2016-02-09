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

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GridView gridView = (GridView)findViewById(R.id.gridview);
    final BooksAdapter booksAdapter = new BooksAdapter(this, books);
    gridView.setAdapter(booksAdapter);

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Book book = books[position];
        book.toggleFavorite();
        booksAdapter.notifyDataSetChanged();
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

}
