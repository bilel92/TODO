package com.first.sqlite.tekup.bilel.todo.DataSource;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.first.sqlite.tekup.bilel.todo.DAO.MySQLiteHelper;
import com.first.sqlite.tekup.bilel.todo.Model.Tache;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bilel on 23/12/2016.
 */

public class TacheDataSource {




    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private String[] allTacheColumns = {
            MySQLiteHelper.TACHE_ID,
            MySQLiteHelper.TACHE_TITILE,
            MySQLiteHelper.TACHE_DESCRiPTION,
            MySQLiteHelper.TACHE_IMAGE,
            MySQLiteHelper.TACHE_VIDEO,
            MySQLiteHelper.TABLE_POSITION,
            MySQLiteHelper.TACHE_USER,
            MySQLiteHelper.TACHE_ETAT,
            MySQLiteHelper.TACHE_DATE};




    public TacheDataSource(Context applicationContext) {
        dbHelper = new MySQLiteHelper(applicationContext);
    }


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    public List<Tache> getAllTache() {
        List<Tache> taches = new ArrayList<Tache>();

        String rawQuery = "SELECT * FROM " + MySQLiteHelper.TABLE_TACHE +","+ MySQLiteHelper.TABLE_POSITION
                + " WHERE" + MySQLiteHelper.TABLE_TACHE +"."+ MySQLiteHelper.TACHE_POSTION + " = " + MySQLiteHelper.TABLE_POSITION +"."+ MySQLiteHelper.POSITION_ID;
        Cursor cursor = database.rawQuery(
                rawQuery,
                null
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Tache tache = cursorToTache(cursor);
            taches.add(tache);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return taches;
    }


    private Tache cursorToTache(Cursor cursor) {
        Tache tache = new Tache();
        tache.setId(cursor.getLong(0));
        tache.setTitle(cursor.getString(1));
        tache.setDescription(cursor.getString(2));
        tache.setImage(cursor.getString(3));
        tache.setVideo(cursor.getString(4));
        tache.setPosition(cursor.getInt(5));
        tache.setUser(cursor.getInt(6));
        tache.setEtat(cursor.getInt(7));

        String s= cursor.getString(8);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        try {
            d=  dateFormat.parse(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tache.setDate(d);

        return tache;
    }



}

