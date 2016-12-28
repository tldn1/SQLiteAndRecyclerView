package com.tldn1.sqliteandrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 12/28/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "contact_db";
    private static  String TB_NAME = "contact_info";
    private static int DB_VERSION = 1;

    private static String ID  = "id";
    private static String NAME  = "name";
    private static String EMAIL  = "email";

    private static String QUERY = "create table " + TB_NAME + " ( " +
            ID+" int auto_increment, " +
            NAME+" text," +
            EMAIL+" text" +
            ")";



    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TB_NAME+" IF EXISTS");
        sqLiteDatabase.execSQL(QUERY);
    }

    public void addContact(String name,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME,name);
        cv.put(EMAIL,email);
        db.insert(TB_NAME,null,cv);
    }
    public List<ContactModel> getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from "+TB_NAME,null);

        String name="";
        String email="";
        int id=0;

        ArrayList<ContactModel> arrayList = new ArrayList<>();

        if(c.moveToFirst()){
            do{
                id =c.getInt(0);
                name = c.getString(1);
                email = c.getString(1);

                ContactModel contactModel = new ContactModel(id,name,email);
                arrayList.add(contactModel);
            }while (c.moveToNext());

        }
        return arrayList;
    }
}
