package com.example.jayson.assignment6.repository.courierpackagerepository.settings.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jayson.assignment6.config.databases.DBConstants;
import com.example.jayson.assignment6.domain.courierpackage.settings.PackageSizeType;
import com.example.jayson.assignment6.repository.courierpackagerepository.settings.PackageSizeTypeRespository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class PackageSizeTypeRepositoryImpl extends SQLiteOpenHelper implements PackageSizeTypeRespository {

    public static final String TABLE_NAME = "packagesizetype";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_STATE = "state";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_STATE + " TEXT NOT NULL );";

    public PackageSizeTypeRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public PackageSizeType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_STATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final PackageSizeType PackageSizeType = new PackageSizeType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                    .build();
            return PackageSizeType;
        } else {
            return null;
        }
    }

    @Override
    public PackageSizeType save(PackageSizeType entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_STATE, entity.getState());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        PackageSizeType insertedEntity = new PackageSizeType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public PackageSizeType update(PackageSizeType entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
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
    public PackageSizeType delete(PackageSizeType entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<PackageSizeType> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<PackageSizeType> PackageSizeType = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final PackageSizeType setting = new PackageSizeType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                        .build();
                PackageSizeType.add(setting);
            } while (cursor.moveToNext());
        }
        return PackageSizeType;
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
