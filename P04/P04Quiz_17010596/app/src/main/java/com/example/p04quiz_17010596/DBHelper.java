package com.example.p04quiz_17010596;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME = "cars.db";
    private static  int DATABASE_VER = 1;

    private static  final String TABLE_TASK = "Car";
    private static  final String COLUMN_ID = "_id";
    private static  final String COLUMN_BRAND = "brand";
    private static  final String COLUMN_LITRE = "litre";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_TASK +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_LITRE + " REAL,"
                + COLUMN_BRAND + " TEXT )";
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        // Create table(s) again
        onCreate(db);
    }

    public void insertTask(String brand, double litre){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_BRAND,brand);
        values.put(COLUMN_LITRE,litre);

        db.insert(TABLE_TASK,null,values);
        db.close();
    }
    public ArrayList<Car> getTaskContent() {
        // Create an ArrayList that holds String objects
        ArrayList<Car> tasks = new ArrayList<Car>();
        // Select all the tasks' description
        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_BRAND + ", "
                + COLUMN_LITRE
                + " FROM " + TABLE_TASK;


        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);

        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                int id = cursor.getInt(0);
                String description = cursor.getString(1);
                double star = cursor.getDouble(2);
                Car obj = new Car(id,description,star);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return tasks;
    }

}
