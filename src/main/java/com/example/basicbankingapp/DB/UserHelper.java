package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'American Chauhan', 'americanchauhan@gmail.com','0001','9988859740', 135000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Khushboo Kumari', 'ks@gmail.com','0002','8083067692', 150000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Anwesha Mishra', 'am@gmail.com','0003','9937563032', 122000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Akash Deep', 'ad@gmail.com','0004','8210735668', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Abinash Sinha', 'ab@gmail.com','0005','9142629868', 75000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Abhishek Joshi', 'aj@gmail.com','0006','9621502988', 65000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Palik Dhadwal', 'pd@gmail.com','0007','7240654372', 45000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Shobhan Rath', 'sr@gmail.com','0008','7789802093', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Inderjeet Kaur', 'ik@gmail.com','0009','7986012503', 105000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Kumar', 'rk@gmail.com','0010','7986929667', 99000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}