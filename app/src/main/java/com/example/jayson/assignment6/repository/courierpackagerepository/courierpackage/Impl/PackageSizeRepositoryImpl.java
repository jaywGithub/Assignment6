package com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jayson.assignment6.config.databases.DBConstants;
import com.example.jayson.assignment6.domain.courierpackage.PackageSize;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.PackageSizeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class PackageSizeRepositoryImpl extends SQLiteOpenHelper implements PackageSizeRepository {

    public static final String TABLE_NAME = "packagesize";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SMALLBOX = "smallBox";
    public static final String COLUMN_MEDIUMBOX = "mediumBox";
    public static final String COLUMN_LARGEBOX = "largeBox";
    public static final String COLUMN_STATE = "state";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SMALLBOX + " TEXT NOT NULL , "
            + COLUMN_MEDIUMBOX + " TEXT NOT NULL , "
            + COLUMN_LARGEBOX + " TEXT  NOT NULL , "
            + COLUMN_STATE + " TEXT NOT NULL );";

    public PackageSizeRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public PackageSize findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_SMALLBOX,
                        COLUMN_MEDIUMBOX,
                        COLUMN_LARGEBOX,
                        COLUMN_STATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final PackageSize packageSize = new PackageSize.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .smallBox(cursor.getString(cursor.getColumnIndex(COLUMN_SMALLBOX)))
                    .mediumBox(cursor.getString(cursor.getColumnIndex(COLUMN_MEDIUMBOX)))
                    .largeBox(cursor.getString(cursor.getColumnIndex(COLUMN_LARGEBOX)))
                    .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                    .build();

            return packageSize;
        } else {
            return null;
        }
    }

    @Override
    public PackageSize save(PackageSize entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SMALLBOX, entity.getSmallBox());
        values.put(COLUMN_MEDIUMBOX, entity.getMediumBox());
        values.put(COLUMN_LARGEBOX, entity.getLargeBox());
        values.put(COLUMN_STATE, entity.getState());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        PackageSize insertedEntity = new PackageSize.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public PackageSize update(PackageSize entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SMALLBOX, entity.getSmallBox());
        values.put(COLUMN_MEDIUMBOX, entity.getMediumBox());
        values.put(COLUMN_LARGEBOX, entity.getLargeBox());
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
    public PackageSize delete(PackageSize entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<PackageSize> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<PackageSize> packageSizes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final PackageSize packageSize = new PackageSize.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .smallBox(cursor.getString(cursor.getColumnIndex(COLUMN_SMALLBOX)))
                        .mediumBox(cursor.getString(cursor.getColumnIndex(COLUMN_MEDIUMBOX)))
                        .largeBox(cursor.getString(cursor.getColumnIndex(COLUMN_LARGEBOX)))
                        .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                        .build();
                packageSizes.add(packageSize);
            } while (cursor.moveToNext());
        }
        return packageSizes;
    }

    @Override
    public int deleteAll() {

        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
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
