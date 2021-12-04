package com.example.getyourbook.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Bookdbhelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = Bookdbhelper.class.getSimpleName();
    private static final String DATABASE_NAME="books.db";
    private static final int DATABASE_VERSION=1;

    public Bookdbhelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table

        String SQL_BOOKS_TABLE = "CREATE TABLE " + ContractClass.PetEntry.TABLE_NAME + " ("
                + ContractClass.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ContractClass.PetEntry.COLOUMN_BOOK_NAME + " TEXT NOT NULL, "
                + ContractClass.PetEntry.COLOUMN_BOOK_STYLE+ " TEXT, "
                + ContractClass.PetEntry.COLOUMN_BOOK_PRICE+ " INTEGER NOT NULL, "
                + ContractClass.PetEntry.COLOUMN_BOOK_DESCRIPTION+ " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}


