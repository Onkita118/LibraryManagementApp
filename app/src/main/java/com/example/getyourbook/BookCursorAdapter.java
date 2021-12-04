package com.example.getyourbook;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.getyourbook.data.ContractClass;

public class BookCursorAdapter extends CursorAdapter {
    public BookCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //connecting views name and publisher in the list-item layout which we want to connect
        TextView name= (TextView)view.findViewById(R.id.name);
        TextView publisher=(TextView)view.findViewById(R.id.returned);
       // TextView price=(TextView)view.findViewById(R.id.price);

        //getting the coloumn index
        int nameColoumnIndex=cursor.getColumnIndex(ContractClass.PetEntry.COLOUMN_BOOK_NAME);
        int descriptionColoumnIndex=cursor.getColumnIndex(ContractClass.PetEntry.COLOUMN_BOOK_STYLE);
        int  priceColoumnndex=cursor.getColumnIndex(ContractClass.PetEntry.COLOUMN_BOOK_PRICE);

        //fetching data of the coloumn index
        String bookName=cursor.getString(nameColoumnIndex);
        String publisherName=cursor.getString(descriptionColoumnIndex);
        String priceVal=cursor.getString(priceColoumnndex);

        int n=0;
         n=Integer.parseInt(publisherName);

         if(n==1)
             publisher.setText("Returned Status- YES");
         else if(n==2)
             publisher.setText("Returned Status- NO");
        //setting the attributes for current book
        name.setText(bookName);
        //publisher.setText(publisherName);
       // price.setText(priceVal);


    }
}
