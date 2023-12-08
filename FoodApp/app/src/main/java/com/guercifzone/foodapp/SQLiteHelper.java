package com.guercifzone.foodapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String email,String type,String address,String assurance,String date_sing,String date_burn,byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO STUDENT VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, email);
        statement.bindString(3,type);
        statement.bindString(4,address);
        statement.bindString(5,assurance);
        statement.bindString(6,date_sing);
        statement.bindString(7,date_burn);
        statement.bindBlob(8, image);

        statement.executeInsert();
    }

    public void updateData(String name, String email, String type,String address,String assurance,String date_sing,String date_burn,  byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE STUDENT SET name = ?, email = ?,type = ?,address = ?,assurance = ?,date_sing = ?,date_burn = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, email);
        statement.bindString(3, type);
        statement.bindString(4, address);
        statement.bindString(5, assurance);
        statement.bindString(6, date_sing);
        statement.bindString(7, date_burn);
        statement.bindBlob(8, image);
        statement.bindDouble(9, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM STUDENT WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
