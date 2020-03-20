package com.example.constraintlayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="PATIENT.db";
    public static final String TABLE_NAME="PATIENT_RECORD";
    public static final String COL_1="PATIENT_ID";
    public static final String COL_2="FIRST_NAME";
    public static final String COL_3="LAST_NAME";
    public static final String COL_4="DATE_OF_BIRTH";
    public static final String COL_5="PHONE_NUMBER";
    public static final String COL_6="EMAIL";
    public static final String COL_7="BLOOD_GROUP";
    public static final String COL_8="PATIENT_HISTORY";
    public static final String COL_9="DOCTOR_NAME";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ TABLE_NAME+"( PATIENT_ID integer primary key,FIRST_NAME text,LAST_NAME text,DATE_OF_BIRTH text,PHONE_NUMBER text,EMAIL text,BLOOD_GROUP text,PATIENT_HISTORY text,DOCTOR_NAME text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public boolean insertdata(String id, String fname, String lname, String dob, String PhoneNumber, String email, String bloodgrp, String patient_history, String Doc_Name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, lname);
        contentValues.put(COL_4, dob);
        contentValues.put(COL_5, PhoneNumber);
        contentValues.put(COL_6, email);
        contentValues.put(COL_7, bloodgrp);
        contentValues.put(COL_8, patient_history);
        contentValues.put(COL_9, Doc_Name);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    }



