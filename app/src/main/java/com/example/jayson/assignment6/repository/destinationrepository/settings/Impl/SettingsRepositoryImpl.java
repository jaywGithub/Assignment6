package com.example.jayson.assignment6.repository.destinationrepository.settings.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jayson.assignment6.config.databases.DBConstants;
import com.example.jayson.assignment6.domain.destination.settings.Settings;
import com.example.jayson.assignment6.repository.destinationrepository.settings.SettingsRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JAYSON on 2016-04-23.
 */
public class SettingsRepositoryImpl extends SQLiteOpenHelper implements SettingsRepository {

    public static final String TABLE_NAME = "branchSettings";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "firstName";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL );";

    public SettingsRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
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

    @Override
    public Settings findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Settings settings = new Settings.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();

            return settings;
        } else {
            return null;
        }
    }

    @Override
    public Settings save(Settings entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Settings insertedEntity = new Settings.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Settings update(Settings entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Settings delete(Settings entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Settings> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Settings> settings = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Settings setting = new Settings.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                settings.add(setting);
            } while (cursor.moveToNext());
        }
        return settings;
    }

    @Override
    public int deleteAll() {

        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

}
