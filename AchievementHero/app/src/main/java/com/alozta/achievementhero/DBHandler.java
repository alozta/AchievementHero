package com.alozta.achievementhero;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alozta on 8/14/16.
 */
public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "entries_info";
    private static final String TABLE_ENTRY = "entry_table";
    private static final String KEY_ID = "id";
    private static final String ENTRY = "entry";
    public static final String DATE = "date";
    public static final String COLOR = "color";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_ENTRY + "("
        + KEY_ID + " ," + ENTRY + " ," + DATE
        + " ," + COLOR +  ")";
        db.execSQL(CREATE_TABLE);
        Log.i("DBHandler","onCreate");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENTRY);  // Drop older table if existed
        onCreate(db);       // Creating tables again
        Log.i("DBHandler","onUpgrade");
    }


    public void addEntry(Entry entry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ENTRY, entry.getEntry());
        values.put(DATE, entry.getDate().toString());
        values.put(COLOR, entry.getColor());
        db.insert(TABLE_ENTRY, null, values);       //Inserting Row
        db.close();             //Closing database connection
    }


    public Entry getEntry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ENTRY, new String[] { KEY_ID,
                        ENTRY, DATE, COLOR}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Entry dbEntry = new Entry(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));

        return dbEntry;     //return entry
    }


    public List<Entry> getAllEntries() {
        List<Entry> entryList = new ArrayList<Entry>();
        String selectQuery = "SELECT * FROM " + TABLE_ENTRY;    // Select All Query
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Entry shop = new Entry();
                shop.setId(Integer.parseInt(cursor.getString(0)));
                shop.setEntry(cursor.getString(1));
                shop.setDate(cursor.getString(2));
                shop.setColor(Integer.parseInt(cursor.getString(3)));

                entryList.add(shop);
            } while (cursor.moveToNext());
        }
        return entryList;
    }


    /*
    * Return: Total n.o. entry records
    */
    public int getEntryCount() {
        String countQuery = "SELECT * FROM " + TABLE_ENTRY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }


    public int updateEntry(Entry entry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ENTRY, entry.getEntry());
        values.put(DATE, entry.getDate());
        values.put(COLOR, entry.getColor());

        return db.update(TABLE_ENTRY, values, KEY_ID + " = ?",
                new String[]{String.valueOf(entry.getId())});
    }


    public void deleteEntry(Entry entry) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ENTRY, KEY_ID + " = ?",
                new String[] { String.valueOf(entry.getId()) });
        db.close();
    }
}
