package com.example.jayson.assignment6.repository.customerrepository.customer.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jayson.assignment6.config.databases.DBConstants;
import com.example.jayson.assignment6.domain.customer.CustomerAddress;
import com.example.jayson.assignment6.repository.customerrepository.customer.CustomerAddressRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class CustomerAddressRepositoryImpl extends SQLiteOpenHelper implements CustomerAddressRepository{

    public static final String TABLE_NAME = "customeraddress";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CITYNAME = "cityName";
    public static final String COLUMN_AREANAME = "areaName";
    public static final String COLUMN_AREACODE = "areaCode";
    public static final String COLUMN_ADDRESSTYPEID = "addressTypeId";
    public static final String COLUMN_STATE = "state";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CITYNAME + " TEXT NOT NULL , "
            + COLUMN_AREANAME + " TEXT NOT NULL , "
            + COLUMN_AREACODE + " TEXT  NOT NULL , "
            + COLUMN_ADDRESSTYPEID + " TEXT  NOT NULL , "
            + COLUMN_STATE + " TEXT NOT NULL );";


    public CustomerAddressRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public CustomerAddress findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CITYNAME,
                        COLUMN_AREANAME,
                        COLUMN_AREACODE,
                        COLUMN_ADDRESSTYPEID,
                        COLUMN_STATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final CustomerAddress customerAddress = new CustomerAddress.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .cityName(cursor.getString(cursor.getColumnIndex(COLUMN_CITYNAME)))
                    .areaName(cursor.getString(cursor.getColumnIndex(COLUMN_AREANAME)))
                    .areaCode(cursor.getString(cursor.getColumnIndex(COLUMN_AREACODE)))
                    .addressTypeId(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESSTYPEID)))
                    .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                    .build();

            return customerAddress;
        } else {
            return null;
        }
    }

    @Override
    public CustomerAddress save(CustomerAddress entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ADDRESSTYPEID, entity.getAddressTypeId());
        values.put(COLUMN_CITYNAME, entity.getCityName());
        values.put(COLUMN_AREANAME, entity.getAreaName());
        values.put(COLUMN_AREACODE, entity.getAreaCode());
        values.put(COLUMN_STATE, entity.getState());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        CustomerAddress insertedEntity = new CustomerAddress.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public CustomerAddress update(CustomerAddress entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ADDRESSTYPEID, entity.getAddressTypeId());
        values.put(COLUMN_CITYNAME, entity.getCityName());
        values.put(COLUMN_AREANAME, entity.getAreaName());
        values.put(COLUMN_AREACODE, entity.getAreaCode());
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
    public CustomerAddress delete(CustomerAddress entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<CustomerAddress> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<CustomerAddress> customerAddresses = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final CustomerAddress customerAddress = new CustomerAddress.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .cityName(cursor.getString(cursor.getColumnIndex(COLUMN_CITYNAME)))
                        .areaName(cursor.getString(cursor.getColumnIndex(COLUMN_AREANAME)))
                        .areaCode(cursor.getString(cursor.getColumnIndex(COLUMN_AREACODE)))
                        .addressTypeId(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESSTYPEID)))
                        .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                        .build();
                customerAddresses.add(customerAddress);
            } while (cursor.moveToNext());
        }
        return customerAddresses;
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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int newVersion, int oldVersion) {

        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
