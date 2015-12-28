package com.example.utopia.activitytemplate.datastorage.sqlite;

import android.content.Context;

/**
 * Created by weiwei on 11/10/15.
 */
public class SQLiteUtil {

    public static void save2SQLite(Context context){
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(context,"Book.db",null,1);
        dbHelper.getWritableDatabase();
    }

}
