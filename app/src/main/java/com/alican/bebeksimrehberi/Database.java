package com.alican.bebeksimrehberi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {


    public Database(@Nullable Context context) {
        super(context, "BabyNames.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS \"babynames\" (\n" +
                "\t\"name_id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"name_explanation\"\tINTEGER,\n" +
                "\t\"fav\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"name_id\" AUTOINCREMENT)\n" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS babynames");
        onCreate(db);

    }
}



































