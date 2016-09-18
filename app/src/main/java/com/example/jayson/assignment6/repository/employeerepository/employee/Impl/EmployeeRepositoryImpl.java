package com.example.jayson.assignment6.repository.employeerepository.employee.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jayson.assignment6.config.databases.DBConstants;
import com.example.jayson.assignment6.domain.employee.Employee;
import com.example.jayson.assignment6.repository.employeerepository.employee.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JAYSON on 2016-04-23.
 */
public class EmployeeRepositoryImpl extends SQLiteOpenHelper implements EmployeeRepository {

    public static final String TABLE_NAME = "employee";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "firstName";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_LICENSE = "license";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIRSTNAME + " TEXT  NOT NULL , "
            + COLUMN_LASTNAME + " TEXT  NOT NULL , "
            + COLUMN_LICENSE + " TEXT NOT NULL );";

    public EmployeeRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Employee findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_FIRSTNAME,
                        COLUMN_LASTNAME,
                        COLUMN_LICENSE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Employee Employee = new Employee.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .license(cursor.getString(cursor.getColumnIndex(COLUMN_LICENSE)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .surname(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                    .build();
            return Employee;
        } else {
            return null;
        }
    }

    @Override
    public Employee save(Employee entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_LICENSE, entity.getLicense());
        values.put(COLUMN_FIRSTNAME, entity.getName());
        values.put(COLUMN_LASTNAME, entity.getSurname());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Employee insertedEntity = new Employee.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Employee update(Employee entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_LICENSE, entity.getLicense());
        values.put(COLUMN_FIRSTNAME, entity.getName());
        values.put(COLUMN_LASTNAME, entity.getSurname());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Employee delete(Employee entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Employee> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Employee> Employee = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Employee setting = new Employee.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .license(cursor.getString(cursor.getColumnIndex(COLUMN_LICENSE)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                        .build();
                Employee.add(setting);
            } while (cursor.moveToNext());
        }
        return Employee;
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
