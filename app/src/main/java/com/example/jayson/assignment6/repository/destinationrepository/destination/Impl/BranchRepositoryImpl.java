package com.example.jayson.assignment6.repository.destinationrepository.destination.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jayson.assignment6.config.databases.DBConstants;
import com.example.jayson.assignment6.domain.destination.Branch;
import com.example.jayson.assignment6.repository.destinationrepository.destination.BranchRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JAYSON on 2016-04-23.
 */
public class BranchRepositoryImpl extends SQLiteOpenHelper implements BranchRepository{

    public static final String TABLE_NAME = "branch";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL );";

    public BranchRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Branch findById(Long id) {

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
            final Branch Branch = new Branch.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();
            return Branch;
        } else {
            return null;
        }
    }

    @Override
    public Branch save(Branch entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Branch insertedEntity = new Branch.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Branch update(Branch entity) {

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
    public Branch delete(Branch entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Branch> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Branch> Branch = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Branch setting = new Branch.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                Branch.add(setting);
            } while (cursor.moveToNext());
        }
        return Branch;
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
