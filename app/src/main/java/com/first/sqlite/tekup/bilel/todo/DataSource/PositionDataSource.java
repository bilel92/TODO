package com.first.sqlite.tekup.bilel.todo.DataSource;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.first.sqlite.tekup.bilel.todo.DAO.MySQLiteHelper;
import com.first.sqlite.tekup.bilel.todo.Model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilel on 23/12/2016.
 */

public class PositionDataSource {




    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private String[] allPositionColumns = {
            MySQLiteHelper.POSITION_ID,
            MySQLiteHelper.POSITION_LONG,
            MySQLiteHelper.POSITION_LAT};




    public PositionDataSource(Context applicationContext) {
        dbHelper = new MySQLiteHelper(applicationContext);
    }


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    public List<Position> getAllPosition() {
        List<Position> positions = new ArrayList<Position>();

            Cursor cursor = database.query(MySQLiteHelper.TABLE_POSITION,
                    allPositionColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Position position = cursorToPosition(cursor);
                positions.add(position);
                cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();
            return positions;
        }


    private Position cursorToPosition(Cursor cursor) {
        Position position = new Position();
        position.setId(cursor.getLong(0));
        position.setLatitude(cursor.getDouble(1));
        position.setLongitude(cursor.getDouble(2));
        return position;
    }

}
