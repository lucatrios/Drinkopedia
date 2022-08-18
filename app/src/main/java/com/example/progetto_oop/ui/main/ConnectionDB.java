package com.example.progetto_oop.ui.main;

import static android.content.Context.MODE_PRIVATE;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Paths;
import java.sql.ResultSet;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.progetto_oop.modelli.Cocktail;


public class ConnectionDB extends SQLiteOpenHelper {

    private static final String dbname = "Cocktailsalvati.db";

    public ConnectionDB(Context context) {
        super(context, dbname, null, 6);


    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String qry="create table Cocktail (numero integer primary key, id integer, name text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Cocktail");
        onCreate(db);
    }

    public  String addRecord(int p1, String p2)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("id",p1);
        cv.put("name",p2);

        long res=db.insert("Cocktail",null,cv);

        if(res==-1)
            return "Failed";
        else{

            return "Successfully inserted";}
    }

    public String removeRecord(int p1, String p2)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        long res=db.delete("Cocktail","id = ? AND name = ?",new String[]{Integer.toString(p1), p2});

        if(res==-1)
            return "Failed";
        else{
            System.out.println("ELEMENTO RIMOSSO");
            return "Successfully deleted";}
    }

    public int [] getCocktailSalvati(){

        SQLiteDatabase db=this.getReadableDatabase();
        String selectQuery = "SELECT id from Cocktail";
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        int i []= new int[61];
        int j=0;
        while(true) {

            if(cursor.isAfterLast())
                break;

            i[j]=cursor.getInt(0);
            //System.out.println("id:" + cursor.getInt(0));
            j++;
            cursor.moveToNext();
        }
        cursor.close();
        //System.out.println("Lunghezza i:" + j);
        return i;
    }


    public int getNumeroCocktailSalvati(){

        SQLiteDatabase db=this.getReadableDatabase();
        String selectQuery = "SELECT id from Cocktail";
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        int h []= new int[61];
        int j=0;
        while(true) {

            if(cursor.isAfterLast())
                break;

            h[j]=cursor.getInt(0);
            j++;
            cursor.moveToNext();

        }
        cursor.close();
        return j;
    }


}