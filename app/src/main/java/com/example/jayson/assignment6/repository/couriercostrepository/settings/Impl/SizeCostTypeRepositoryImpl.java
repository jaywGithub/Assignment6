package com.example.jayson.assignment6.repository.couriercostrepository.settings.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jayson.assignment6.config.databases.DBConstants;
import com.example.jayson.assignment6.domain.couriercost.settings.SizeCostType;
import com.example.jayson.assignment6.repository.couriercostrepository.settings.SizeCostTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class SizeCostTypeRepositoryImpl extends SQLiteOpenHelper implements SizeCostTypeRepository {

    public static final String TABLE_NAME = "sizecosttype";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SIZE= "size";
    public static final String COLUMN_COST = "cost";
    public static final String COLUMN_STATE = "state";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SIZE + " TEXT NOT NULL , "
            + COLUMN_COST + " TEXT NOT NULL , "
            + COLUMN_STATE + " TEXT NOT NULL );";

    public SizeCostTypeRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public SizeCostType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_SIZE,
                        COLUMN_COST,
                        COLUMN_STATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final SizeCostType sizeCostType = new SizeCostType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .size(cursor.getString(cursor.getColumnIndex(COLUMN_SIZE)))
                    .cost(cursor.getDouble(cursor.getColumnIndex(COLUMN_COST)))
                    .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                    .build();

            return sizeCostType;
        } else {
            return null;
        }
    }

    @Override
    public SizeCostType save(SizeCostType entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SIZE, entity.getSize());
        values.put(COLUMN_COST, entity.getCost());
        values.put(COLUMN_STATE, entity.getState());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        SizeCostType insertedEntity = new SizeCostType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public SizeCostType update(SizeCostType entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SIZE, entity.getSize());
        values.put(COLUMN_COST, entity.getCost());
        values.put(COLUMN_STATE, entity.getState());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public SizeCostType delete(SizeCostType entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<SizeCostType> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<SizeCostType> sizeCostTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final SizeCostType sizeCostType = new SizeCostType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .size(cursor.getString(cursor.getColumnIndex(COLUMN_SIZE)))
                        .cost(cursor.getDouble(cursor.getColumnIndex(COLUMN_COST)))
                        .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                        .build();
                sizeCostTypes.add(sizeCostType);
            } while (cursor.moveToNext());
        }
        return sizeCostTypes;
    }

    @Override
    public int deleteAll() {

        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
