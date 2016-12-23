package com.first.sqlite.tekup.bilel.todo.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by bilel on 23/12/2016.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "todo.db";
    private static final int DATABASE_VERSION = 1;

    //************* Table tache ****************//

    public static final String TABLE_TACHE = "tache";
    public static final String TACHE_ID = "_id";
    public static final String TACHE_TITILE= "title";
    public static final String TACHE_DESCRiPTION = "description";
    public static final String TACHE_IMAGE = "image";
    public static final String TACHE_VIDEO = "video";
    public static final String TACHE_POSTION = "position";
    public static final String TACHE_USER = "user";
    public static final String TACHE_ETAT = "etat";
    public static final String TACHE_DATE = "date";


    private static final String TACHE_CREATE = "create table "
            + TABLE_TACHE + "( "
            + TACHE_ID + " integer primary key autoincrement, "
            + TACHE_TITILE + " text not null,"
            + TACHE_DESCRiPTION + " text not null,"
            + TACHE_IMAGE  + " text,"
            + TACHE_VIDEO + " text,"
            + TACHE_POSTION + " int not null,"
            + TACHE_USER + " int not null,"
            + TACHE_DATE + " date,"
            + TACHE_ETAT + " int default 0 );";

    //************* Table position ****************//

    public static final String TABLE_POSITION = "position";
    public static final String POSITION_ID = "_id";
    public static final String POSITION_LONG = "longitude";
    public static final String POSITION_LAT = "latitude";

    private static final String POSITION_CREATE = "create table "
            + TABLE_POSITION + "( "
            + POSITION_ID + " integer primary key autoincrement, "
            + POSITION_LONG + " float, "
            + POSITION_LAT + " float);";






    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TACHE_CREATE);
        db.execSQL(POSITION_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TACHE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSITION);
        onCreate(db);
    }
}


