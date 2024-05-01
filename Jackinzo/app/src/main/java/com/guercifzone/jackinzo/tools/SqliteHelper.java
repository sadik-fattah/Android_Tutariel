package com.guercifzone.jackinzo.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper{


    public SqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void  QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void InsertData(String name, String email,String type,String address,String assurance,String date_sing,String date_burn,byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO RECORD VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,email);
        statement.bindString(3,type);
        statement.bindString(4,address);
        statement.bindString(5,assurance);
        statement.bindString(6,date_sing);
        statement.bindString(7,date_burn);
        statement.bindBlob(8,image);
        statement.executeInsert();
    }
    public void UpdateData(String name, String email,String type,String address,String assurance,String date_sing,String date_burn,byte[] image,int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE RECORD SET name= ?, email = ?, type = ?, address = ?, assurance = ?,date_sing = ?, date_burn = ?, image = ? WHERE id = ?";
    SQLiteStatement statement = database.compileStatement(sql);
    statement.bindString(1,name);
        statement.bindString(2,email);
        statement.bindString(3,type);
        statement.bindString(4,address);
        statement.bindString(5,assurance);
        statement.bindString(6,date_sing);
        statement.bindString(7,date_burn);
        statement.bindBlob(8,image);
        statement.bindDouble(9,(double) id);
    statement.execute();
    database.close();
    }
  public void  DeleteData(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM RECORD WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double) id);
        statement.execute();
        database.close();
  }
  public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return  database.rawQuery(sql,null);
  }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
